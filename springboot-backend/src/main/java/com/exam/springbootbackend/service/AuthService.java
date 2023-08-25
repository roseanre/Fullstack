package com.exam.springbootbackend.service;

import com.exam.springbootbackend.repository.UserRepository;

import com.exam.springbootbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }
        user.setPassword(user.getPassword()); // Store password as is (for now)
        return userRepository.save(user);
    }

    public boolean login(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        return existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword());
    }
}
