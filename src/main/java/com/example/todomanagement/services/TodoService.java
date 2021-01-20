package com.example.todomanagement.services;

import com.example.todomanagement.models.TodoModel;
import com.example.todomanagement.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    List<TodoModel> findAllTodosByUsername(String username);

    List<TodoModel> findAllTodosByUsername(String username, boolean isCompleted);

    Optional<TodoModel> findTodo(long id, String username);
}
