package com.example.todomanagement.jpa.repositories;

import com.example.todomanagement.jpa.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long>, JpaSpecificationExecutor<Todo> {

    Optional<Todo> findByIdAndUser_id(long todoId, long userId);
}
