package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {
}