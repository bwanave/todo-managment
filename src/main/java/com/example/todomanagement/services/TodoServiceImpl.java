package com.example.todomanagement.services;

import com.example.todomanagement.jpa.entities.Todo;
import com.example.todomanagement.jpa.entities.User;
import com.example.todomanagement.jpa.repositories.TodoRepository;
import com.example.todomanagement.jpa.specifications.TodoSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.todomanagement.jpa.specifications.TodoSpecifications.hasUser;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class TodoServiceImpl implements TodoService {

    private final UserService userService;
    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(UserService userService, TodoRepository todoRepository) {
        this.userService = userService;
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAllTodosByUsername(String username) {
        User user = userService.getUser(username);
        return todoRepository.findAll(where(hasUser(user.getUsername())));
    }

    @Override
    public List<Todo> findAllTodosByUsername(String username, boolean isCompleted) {
        User user = userService.getUser(username);
        Specification<Todo> specification = where(hasUser(user.getUsername()))
                .and(TodoSpecifications.isCompletedTodo(isCompleted));
        return todoRepository.findAll(specification);
    }

    @Override
    public Optional<Todo> findTodo(long id, String username) {
        User user = userService.getUser(username);
        return todoRepository.findByIdAndUser_id(id, user.getId());
    }

    @Override
    public Todo createTodo(String username, Todo todo) {
        User user = userService.getUser(username);
        todo.setUser(user);
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Todo todo, Todo oldTodo) {
        oldTodo.setDescription(todo.getDescription());
        oldTodo.setTargetDate(todo.getTargetDate());
        oldTodo.setCompleted(todo.isCompleted());
        return todoRepository.save(oldTodo);
    }

    @Override
    public Optional<Todo> deleteTodo(String username, long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent())
            todoRepository.deleteById(id);
        return todo;
    }
}