package de.novatec.todoui;

import java.util.List;

public class TodoListResource {

    private List<TodoResource> todos;

    public List<TodoResource> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoResource> todos) {
        this.todos = todos;
    }
}
