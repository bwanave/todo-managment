package com.example.todomanagement.services;

import com.example.todomanagement.jpa.entities.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    List<Todo> findAllTodosByUsername(String username);

    List<Todo> findAllTodosByUsername(String username, boolean isCompleted);

    Optional<Todo> findTodo(long id, String username);

    Todo createTodo(String username, Todo todo);

    Todo updateTodo(Todo todo, Todo oldTodo);

    Optional<Todo> deleteTodo(String username, long id);
}
