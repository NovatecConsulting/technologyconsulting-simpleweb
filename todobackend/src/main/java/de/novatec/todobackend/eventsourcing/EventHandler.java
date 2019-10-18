package de.novatec.todobackend.eventsourcing;

import de.novatec.todobackend.todo.TodoEvent;

/** TODO implement me */
public interface EventHandler {

    void processEvent(TodoEvent event);

}
