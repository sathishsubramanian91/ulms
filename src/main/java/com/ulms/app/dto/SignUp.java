package com.ulms.app.dto;

import lombok.Data;

@Data
public class SignUp {
    private String username;
    private String email;
    private String password;
    private String role;
}
