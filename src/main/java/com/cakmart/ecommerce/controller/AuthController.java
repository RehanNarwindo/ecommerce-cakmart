package com.cakmart.ecommerce.controller;

import com.cakmart.ecommerce.dto.LoginRequest;
import com.cakmart.ecommerce.dto.RegisterRequest;
import com.cakmart.ecommerce.dto.RegisterResponse;
import com.cakmart.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String token = authService.login(loginRequest);
        return ResponseEntity.ok().body("Bearer " + token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest){
        RegisterResponse response = authService.register(registerRequest);
        System.out.println("Response :");
        System.out.println(response);
        return ResponseEntity.ok(response);
    }
}
