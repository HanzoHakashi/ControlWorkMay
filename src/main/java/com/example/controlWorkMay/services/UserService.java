package com.example.controlWorkMay.services;

import com.example.controlWorkMay.dto.UserDto;
import com.example.controlWorkMay.entity.User;
import com.example.controlWorkMay.mapper.UserMapper;
import com.example.controlWorkMay.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final PasswordEncoder encoder;
    final private UserRepository userRepository;
    private final UserMapper userMapper;
    public void createUser(UserDto user) {
        userRepository.save(User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .login(user.getLogin())
                .password(encoder.encode(user.getPassword()))
                .enable(user.getEnable())
                .role(user.getRole())
                .build());
    }

    public User getUserByUsername(String username) {
        return userRepository.findByEmail(username);
    }
}
