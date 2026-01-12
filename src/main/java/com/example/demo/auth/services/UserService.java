package com.example.demo.auth.services;

import org.springframework.stereotype.Service;

import com.example.demo.auth.dto.CreateUserRequest;
import com.example.demo.auth.dto.UserResponse;
import com.example.demo.auth.mappers.UserMapper;
import com.example.demo.auth.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse createUser(CreateUserRequest request) {
        var user = userMapper.toEntity(request);
        var savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }
}
