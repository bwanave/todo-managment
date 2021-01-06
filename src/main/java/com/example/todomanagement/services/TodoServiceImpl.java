package com.example.todomanagement.services;

import com.example.todomanagement.models.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private static final List<Todo> TODOS;

    static {
        TODOS = new ArrayList<>();
        TODOS.add(new Todo(1, "Learn Springboot", LocalDate.now().plusDays(5)));
        TODOS.add(new Todo(2, "Learn React", LocalDate.now().plusDays(10)));
        TODOS.add(new Todo(3, "Learn Python", LocalDate.now().plusDays(15)));
    }

    @Override
    public List<Todo> getAllTodos() {
        return TODOS;
    }

    @Override
    public Todo getTodo(long id) {
        return TODOS.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid id: " + id));
    }
}
