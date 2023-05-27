package com.example.controlWorkMay.dto;

import com.example.controlWorkMay.entity.UserRole;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    private String name;
    private String email;
    private String login;
    private String password;
    private Boolean enable;
    private UserRole role;
}
