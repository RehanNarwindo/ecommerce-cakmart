package com.cakmart.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {

    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email format")
    private String email;

    @NotBlank(message = "Password must not be empty")
    @Size(min = 8, message = "Password Minimum long 8 character")
    private String password;

}
