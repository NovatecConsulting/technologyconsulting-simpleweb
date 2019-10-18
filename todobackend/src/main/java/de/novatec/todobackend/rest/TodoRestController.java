package de.novatec.todobackend.rest;

import de.novatec.todobackend.todo.Todo;
import de.novatec.todobackend.todo.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    List<Todo> get(){
        return todoService.get();
    }

    @PostMapping("/todos")
    Todo create(@RequestBody Todo todo) {
        return todoService.create(todo.getContent());
    }

    @PutMapping("/todos/{id}")
    Todo update(@PathVariable("id") String id, @RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("/todos/{id}")
    void delete(@PathVariable("id") String id){
        todoService.delete(id);
    }

}

