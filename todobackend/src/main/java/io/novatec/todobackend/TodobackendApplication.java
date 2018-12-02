package io.novatec.todobackend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TodobackendApplication {

	ArrayList<String> todos = new ArrayList<String>();

	@GetMapping("/todos")
	List<String> getTodos(){

		return todos;
	}

	@PostMapping("/todos/{todo}")
	String addTodo(@PathVariable String todo){

		todos.add(todo);
		return "added "+todo;

	}

	@DeleteMapping("/todos/{todo}")
	String deleteTodo(@PathVariable String todo){

		todos.remove(todo);
		return "delete "+todo;

	}

	public static void main(String[] args) {
		SpringApplication.run(TodobackendApplication.class, args);
	}
}
