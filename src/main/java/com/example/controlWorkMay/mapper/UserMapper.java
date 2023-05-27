package com.example.controlWorkMay.mapper;

import com.example.controlWorkMay.dto.UserDto;

import com.example.controlWorkMay.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {

    public static   UserDto fromUser(User user){
        return  UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .login(user.getLogin())
                .password(user.getPassword() )
                .enable(user.getEnable())
                .role(user.getRole())
                .build();
    }

    public static User fromDto(UserDto user){
        return  User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .login(user.getLogin())
                .password(user.getPassword() )
                .enable(user.getEnable())
                .role(user.getRole())
                .build();
    }
}
