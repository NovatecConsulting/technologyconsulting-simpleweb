package de.novatec.todobackend.kafka;

import de.novatec.todobackend.todo.TodoEvent;

/** TODO implement me */
public interface Producer {

    void send(TodoEvent todo);

}
