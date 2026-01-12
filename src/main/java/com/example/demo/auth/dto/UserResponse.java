package com.example.demo.auth.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String email;
    private LocalDateTime createdAt;
}
