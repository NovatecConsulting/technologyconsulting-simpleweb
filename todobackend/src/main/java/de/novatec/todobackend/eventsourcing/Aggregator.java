package de.novatec.todobackend.eventsourcing;

import de.novatec.todobackend.todo.Todo;
import java.util.SortedMap;

/** TODO implement me */
public interface Aggregator {

    SortedMap<String, Todo> getTodos();

}
