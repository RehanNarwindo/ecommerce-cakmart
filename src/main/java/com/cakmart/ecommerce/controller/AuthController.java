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
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest loginRequest) {
        LoginResponse response = authService.login(loginRequest);
        return ResponseEntity.ok(response);
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Validated(ValidationSequence.class) RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? request.getRole() : "user");
        user.setCreatedBy(request.getCreated_by());
        user.setUpdatedBy(request.getUpdated_by());

        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
}
