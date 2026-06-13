package com.tejas.comicverse.controller;

import com.tejas.comicverse.dto.LoginRequest;
import com.tejas.comicverse.dto.LoginResponse;
import com.tejas.comicverse.dto.RegisterRequest;
import com.tejas.comicverse.entity.User;
import com.tejas.comicverse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}