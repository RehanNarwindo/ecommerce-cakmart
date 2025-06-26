package com.cakmart.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.*;


@Setter
@Getter

public class RegisterRequest {

    @NotBlank(message = "Username must not be empty")
    private String username;

    @NotBlank(message = "Password must not be empty")
    @Size(min = 8, message = "Password Minimum long 8 character")
    private String password;

    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email format")
    private String email;

    private String role;

    private String created_by;

    private String updated_by;

}
