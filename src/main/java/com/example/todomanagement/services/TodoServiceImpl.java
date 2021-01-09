package com.example.todomanagement.services;

import com.example.todomanagement.jpa.entities.Todo;
import com.example.todomanagement.jpa.repositories.TodoRepository;
import com.example.todomanagement.models.TodoModel;
import com.example.todomanagement.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoModel> getAllTodos(UserModel userModel) {
        return todoRepository.findAllByUser_id(userModel.getId())
                .stream()
                .map(Todo::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TodoModel> getTodo(long id, UserModel userModel) {
        return todoRepository.findByIdAndUser_id(id, userModel.getId())
                .stream()
                .filter(todo -> todo.getUser().getId() == userModel.getId())
                .filter(todo -> todo.getId() == id)
                .map(Todo::toModel)
                .findFirst();
    }
}
