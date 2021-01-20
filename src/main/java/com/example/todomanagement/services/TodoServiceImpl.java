package com.example.todomanagement.services;

import com.example.todomanagement.jpa.entities.Todo;
import com.example.todomanagement.jpa.repositories.TodoRepository;
import com.example.todomanagement.jpa.specifications.TodoSpecifications;
import com.example.todomanagement.models.TodoModel;
import com.example.todomanagement.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.todomanagement.jpa.specifications.TodoSpecifications.hasUser;

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
    public List<TodoModel> findAllTodosByUsername(String username) {
        UserModel user = this.getUser(username);
        return todoRepository.findAll(Specification.where(hasUser(user.getUsername())))
                .stream()
                .map(Todo::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoModel> findAllTodosByUsername(String username, boolean isCompleted) {
        UserModel user = this.getUser(username);
        Specification<Todo> specification = Specification
                .where(hasUser(user.getUsername()))
                .and(TodoSpecifications.isCompletedTodo(isCompleted));
        return todoRepository.findAll(specification)
                .stream()
                .map(Todo::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TodoModel> findTodo(long id, String username) {
        UserModel user = this.getUser(username);
        return todoRepository.findByIdAndUser_id(id, user.getId())
                .stream()
                .filter(todo -> todo.getUser().getId() == user.getId())
                .filter(todo -> todo.getId() == id)
                .map(Todo::toModel)
                .findFirst();
    }

    private UserModel getUser(String username) {
        Optional<UserModel> user = userService.getUser(username);
        return user.orElseThrow(() -> new RuntimeException("User not found: " + username));
    }
}
