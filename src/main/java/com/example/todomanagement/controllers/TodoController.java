package com.example.todomanagement.controllers;

import com.example.todomanagement.models.Todo;
import com.example.todomanagement.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAll() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getOne(@PathVariable long id) {
        return todoService.getTodo(id);
    }
}
