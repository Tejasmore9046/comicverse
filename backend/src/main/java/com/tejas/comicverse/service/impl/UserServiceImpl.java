package com.tejas.comicverse.service.impl;

import com.tejas.comicverse.dto.LoginRequest;
import com.tejas.comicverse.dto.LoginResponse;
import com.tejas.comicverse.dto.RegisterRequest;
import com.tejas.comicverse.entity.User;
import com.tejas.comicverse.repository.UserRepository;
import com.tejas.comicverse.security.JwtService;
import com.tejas.comicverse.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest request) {

        User user =userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->
                        new RuntimeException("User not found"));

        if(!bCryptPasswordEncoder.matches(
                request.getPassword(),
                user.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        String token =
                jwtService.generateToken(user.getEmail());
        return new LoginResponse(token);
    }

    @Override
    public User register(RegisterRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .role("USER")
                .build();

        return userRepository.save(user);
    }
}
