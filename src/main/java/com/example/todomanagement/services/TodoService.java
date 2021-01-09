package com.example.todomanagement.services;

import com.example.todomanagement.jpa.entities.User;
import com.example.todomanagement.models.TodoModel;
import com.example.todomanagement.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    List<TodoModel> getAllTodos(UserModel userModel);

    Optional<TodoModel> getTodo(long id, UserModel userModel);
}
