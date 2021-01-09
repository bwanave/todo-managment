package com.example.todomanagement.services;

import com.example.todomanagement.models.UserModel;

import java.util.Optional;

public interface UserService {

    Optional<UserModel> getUser(String username);
}
