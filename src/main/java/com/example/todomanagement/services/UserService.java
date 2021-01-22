package com.example.todomanagement.services;

import com.example.todomanagement.jpa.entities.User;

import java.util.Optional;

public interface UserService {

    User getUser(String username);

    Optional<User> findUser(String username);
}
