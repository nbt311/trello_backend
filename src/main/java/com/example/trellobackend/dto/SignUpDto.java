package com.example.trellobackend.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String fullName;;
    private String username;
    private String email;
    private String password;
}
