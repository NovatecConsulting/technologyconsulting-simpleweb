package de.novatec.todoui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TodoUiController {

    @Value("${backend.endpoint}")
    String todosUrl;

    RestTemplate template = new RestTemplate();

    @GetMapping("/")
    public String getItems(Model model) throws InterruptedException {
        System.out.println("Get todos");
        updateModel(model);
        return "items";
    }

    @PostMapping("/create")
    public String addItem(String toDo, Model model) throws InterruptedException {
        System.out.println("Create todo");

        ResponseEntity<TodoResource> response = template.postForEntity(todosUrl +"/todos", new TodoResource(toDo), TodoResource.class);
        updateModel(model);
        return "items";
    }



    @PostMapping("delete/{id}")
    public String setItemDone(@PathVariable("id") String id, Model model) throws InterruptedException {
        System.out.println("Delete todo");
        template.delete(todosUrl + "/todos/" + id);
        updateModel(model);
        return "items";
    }

    @PostMapping("update")
    public String updateTodo(String id, String toDo, Model model) throws InterruptedException {
        System.out.println("Update todo");
        TodoResource resource = new TodoResource(id, toDo);
        template.put(todosUrl + "/todos/" + id, resource);
        updateModel(model);
        return "items";
    }

    private void updateModel(Model model) throws InterruptedException {
        System.out.println("Get todos");
        Thread.sleep(200);
        ResponseEntity<TodoResource[]> responses = template.getForEntity(todosUrl + "/todos", TodoResource[].class);
        model.addAttribute("items", responses.getBody());
    }

}
