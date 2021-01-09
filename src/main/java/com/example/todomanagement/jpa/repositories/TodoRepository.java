package com.example.todomanagement.jpa.repositories;

import com.example.todomanagement.jpa.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByUser_id(long id);

    Optional<Todo> findByIdAndUser_id(long todoId, long userId);
}
