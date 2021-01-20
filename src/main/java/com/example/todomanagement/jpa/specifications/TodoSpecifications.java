package com.example.todomanagement.jpa.specifications;

import com.example.todomanagement.jpa.entities.Todo;
import com.example.todomanagement.jpa.entities.Todo_;
import com.example.todomanagement.jpa.entities.User_;
import org.springframework.data.jpa.domain.Specification;

public class TodoSpecifications {

    private TodoSpecifications() {
    }

    public static Specification<Todo> hasUser(String username) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Todo_.USER).get(User_.USERNAME), username);
    }

    public static Specification<Todo> isCompletedTodo(boolean isCompleted) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(Todo_.IS_COMPLETED), isCompleted);
    }
}
