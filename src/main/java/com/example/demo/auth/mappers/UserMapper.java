package com.example.demo.auth.mappers;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.demo.auth.dto.CreateUserRequest;
import com.example.demo.auth.dto.UserResponse;
import com.example.demo.entity.User;

@Component
public class UserMapper {

    public User toEntity(CreateUserRequest request) {
        return User.builder()
                .email(request.getEmail())
                .passwordHash(request.getPassword())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
