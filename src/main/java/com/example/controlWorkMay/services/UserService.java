package com.example.controlWorkMay.services;

import com.example.controlWorkMay.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
//    private final PasswordEncoder encoder;
    final private UserRepository userRepository;
}
