package com.cakmart.ecommerce.controller;

import com.cakmart.ecommerce.dto.LoginRequest;
import com.cakmart.ecommerce.dto.LoginResponse;
import com.cakmart.ecommerce.dto.RegisterRequest;
import com.cakmart.ecommerce.dto.RegisterResponse;
import com.cakmart.ecommerce.model.User;
import com.cakmart.ecommerce.repository.UserRepository;
import com.cakmart.ecommerce.service.AuthService;
import com.cakmart.ecommerce.validation.groups.ValidationSequence;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Validated(ValidationSequence.class) @NotNull LoginRequest request) {
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Validated(ValidationSequence.class) RegisterRequest request) {
        RegisterResponse response = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}

