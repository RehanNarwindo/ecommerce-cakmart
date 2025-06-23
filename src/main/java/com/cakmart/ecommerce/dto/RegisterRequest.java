package com.cakmart.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private String role;
    private String created_by;
    private String updated_by;

}
