package com.example.controlWorkMay.controller;

import com.example.controlWorkMay.dto.UserDto;
import com.example.controlWorkMay.entity.UserRole;
import com.example.controlWorkMay.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/login";
    }


    @PostMapping("/register")
    public String registerPost(UserDto userDto) {
        System.out.println(userDto.toString());
            userDto.setEnable(true);
            userService.createUser(userDto);
            return "redirect:/login";
    }
}