package de.novatec.todobackend.todo;

import de.novatec.todobackend.eventsourcing.Aggregator;
import de.novatec.todobackend.kafka.Producer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for creating, modifying and deleting todo entries.
 */
@Service
public class TodoService {

    @Autowired
    private Producer topicProducer;

    @Autowired
    private Aggregator aggregator;

    public List<Todo> get() {
        return new ArrayList(aggregator.getTodos().values());
    }

    public Todo create(String content)  {
        // TODO implement me

        return null;
    }

    public Todo update(Todo todo)  {
        // TODO implement me

        return null;
    }

    public void delete(String id) {
        // TODO implement me
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

}
