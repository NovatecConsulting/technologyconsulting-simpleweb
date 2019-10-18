package de.novatec.todobackend.todo;

import java.util.StringTokenizer;

public class TodoEvent {

    private static final String DELIM = "::";

    private TodoEventType eventType;

    private Todo todo;

    public TodoEvent(TodoEventType eventType, Todo todo) {
        this.eventType = eventType;
        this.todo = todo;
    }

    public TodoEvent(String event) {
        StringTokenizer stringTokenizer = new StringTokenizer(event, DELIM);
        this.eventType = TodoEventType.valueOf(stringTokenizer.nextToken());
        this.todo = new Todo(stringTokenizer.nextToken(), stringTokenizer.nextToken());
    }

    public TodoEventType getEventType() {
        return eventType;
    }

    public void setEventType(TodoEventType eventType) {
        this.eventType = eventType;
    }

    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    @Override
    public String toString() {
        return eventType + DELIM + todo.getId() + DELIM + todo.getContent();
    }

}
