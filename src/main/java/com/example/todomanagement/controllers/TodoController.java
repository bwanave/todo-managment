package com.example.todomanagement.controllers;

import com.example.todomanagement.models.TodoModel;
import com.example.todomanagement.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{username}")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoModel>> findAllTodos(@PathVariable String username) {
        List<TodoModel> todos = todoService.findAllTodosByUsername(username);
        return ResponseEntity.ok(todos);
    }

    @GetMapping(name = "/todos", params = {"isCompleted"})
    public ResponseEntity<List<TodoModel>> findAllTodos(@PathVariable String username, @RequestParam boolean isCompleted) {
        List<TodoModel> todos = todoService.findAllTodosByUsername(username, isCompleted);
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<TodoModel> findTodo(@PathVariable String username, @PathVariable long id) {
        TodoModel todo = todoService
                .findTodo(id, username)
                .orElseThrow(() -> new RuntimeException("Invalid Todo Id"));
        return ResponseEntity.ok(todo);
    }
}
