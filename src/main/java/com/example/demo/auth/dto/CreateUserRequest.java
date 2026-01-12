package com.example.demo.auth.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String email;
    private String password;
}
