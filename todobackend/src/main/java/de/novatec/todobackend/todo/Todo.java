package de.novatec.todobackend.todo;

public class Todo {

    /**  Unique identifier (UUID) for a todo. */
    private String id;

    /**  Content of todo entry. */
    private String content;

    public Todo() {
        // Empty on purpose. Used for JSON marshalling.
    }

    public Todo(String id) {
        this.id = id;
    }

    public Todo(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
