package com.cakmart.ecommerce.dto;

import com.cakmart.ecommerce.validation.annotations.UniqueEmail;
import com.cakmart.ecommerce.validation.groups.BasicCheck;
import com.cakmart.ecommerce.validation.groups.DatabaseCheck;
import com.cakmart.ecommerce.validation.groups.FormatCheck;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {

    @NotBlank(message = "Email must not be empty", groups = BasicCheck.class)
    @Email(message = "Invalid email format", groups = FormatCheck.class)
    private String email;

    @NotBlank(message = "Password must not be empty", groups = BasicCheck.class)
    @Size(min = 8, message = "Password must be at least 8 characters", groups = BasicCheck.class)
    private String password;

}
