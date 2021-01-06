package com.example.todomanagement.services;

import com.example.todomanagement.models.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> getAllTodos();

    Todo getTodo(long id);
}
