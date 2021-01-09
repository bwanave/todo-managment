package com.example.todomanagement.controllers;

import com.example.todomanagement.models.TodoModel;
import com.example.todomanagement.models.UserModel;
import com.example.todomanagement.services.TodoService;
import com.example.todomanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users/{username}/todos")
public class TodoController {

    private final TodoService todoService;
    private final UserService userService;

    @Autowired
    public TodoController(TodoService todoService, UserService userService) {
        this.todoService = todoService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<TodoModel>> getAll(@PathVariable String username) {
        UserModel userModel = this.getUser(username);
        List<TodoModel> todoModels = todoService.getAllTodos(userModel);
        return ResponseEntity.ok(todoModels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoModel> getOne(@PathVariable String username, @PathVariable long id) {
        UserModel userModel = this.getUser(username);
        TodoModel todoModel = todoService
                .getTodo(id, userModel)
                .orElseThrow(() -> new RuntimeException("Invalid Todo Id"));
        return ResponseEntity.ok(todoModel);
    }

    private UserModel getUser(String username) {
        Optional<UserModel> userModel = userService.getUser(username);
        return userModel.orElseThrow(() -> new RuntimeException("User not found"));
    }
}
