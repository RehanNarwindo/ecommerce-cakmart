package com.cakmart.ecommerce.dto;

import com.cakmart.ecommerce.validation.annotations.UniqueEmail;
import com.cakmart.ecommerce.validation.groups.BasicCheck;
import com.cakmart.ecommerce.validation.groups.DatabaseCheck;
import com.cakmart.ecommerce.validation.groups.FormatCheck;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.UniqueElements;

@Setter
@Getter

public class RegisterRequest {

    @NotBlank(message = "Username must not be empty", groups = BasicCheck.class)
    private String username;

    @NotBlank(message = "Password must not be empty", groups = BasicCheck.class)
    @Size(min = 8, message = "Password must be at least 8 characters", groups = BasicCheck.class)
    private String password;

    @NotBlank(message = "Email must not be empty", groups = BasicCheck.class)
    @Email(message = "Invalid email format", groups = FormatCheck.class)
    @UniqueEmail(message = "Email already used", groups = DatabaseCheck.class)
    private String email;

    private String role;

    private String created_by;

    private String updated_by;

}
