package de.novatec.todoui;

public class TodoResource {

    private String id;

    private String content;

    public TodoResource() {
        // Empty on purpose. Used for JSON marshalling.
    }

    public TodoResource(String content) {
        this.content = content;
    }

    public TodoResource(String id, String content) {
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

    @Override
    public String toString() {
        return this.content;
    }

}
