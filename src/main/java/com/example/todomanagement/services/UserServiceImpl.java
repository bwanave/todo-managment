package com.example.todomanagement.services;

import com.example.todomanagement.exceptions.UserNotFoundException;
import com.example.todomanagement.jpa.entities.User;
import com.example.todomanagement.jpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Invalid username: " + username));
    }

    @Override
    public Optional<User> findUser(String username) {
        return userRepository.findByUsername(username);
    }
}
