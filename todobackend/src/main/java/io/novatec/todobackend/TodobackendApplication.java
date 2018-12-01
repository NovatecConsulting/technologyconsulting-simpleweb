package io.novatec.todobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class TodobackendApplication {

	ArrayList<String> todos = new ArrayList<String>();

	@GetMapping("/todos")
	ArrayList<String> getTodos(){

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
