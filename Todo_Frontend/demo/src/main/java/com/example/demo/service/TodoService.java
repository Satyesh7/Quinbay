package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Todo save(Todo todo) {
        if (todo.getCreatedAt() == null) {
            todo.setCreatedAt(LocalDateTime.now());
        }
        return repository.save(todo);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Optional<Todo> toggleTodoStatus(String id) {
        Optional<Todo> todoOptional = repository.findById(id);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.setCompleted(!todo.isCompleted());
            todo.setUpdatedAt(LocalDateTime.now());
            return Optional.of(repository.save(todo));
        }
        return Optional.empty();
    }
}