package com.example.todomanagement.controllers;

import com.example.todomanagement.jpa.entities.Todo;
import com.example.todomanagement.models.TodoModel;
import com.example.todomanagement.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<TodoModel> todos = todoService.findAllTodosByUsername(username)
                .stream()
                .map(Todo::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(todos);
    }

    @GetMapping(name = "/todos", params = {"isCompleted"})
    public ResponseEntity<List<TodoModel>> findAllTodos(@PathVariable String username, @RequestParam boolean isCompleted) {
        List<TodoModel> todos = todoService.findAllTodosByUsername(username, isCompleted)
                .stream()
                .map(Todo::toModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<TodoModel> findTodo(@PathVariable String username, @PathVariable long id) {
        return todoService.findTodo(id, username)
                .map(Todo::toModel)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/todos")
    public ResponseEntity<TodoModel> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        TodoModel createdTodo = todoService.createTodo(username, todo).toModel();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTodo.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<TodoModel> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        Optional<Todo> oldTodo = todoService.findTodo(id, username);
        if (oldTodo.isEmpty())
            return ResponseEntity.notFound().build();
        TodoModel updatedTodo = todoService.updateTodo(todo, oldTodo.get()).toModel();
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        Optional<Todo> deletedTodo = todoService.deleteTodo(username, id);
        return deletedTodo.map(todo -> ResponseEntity.noContent().<Void>build())
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
