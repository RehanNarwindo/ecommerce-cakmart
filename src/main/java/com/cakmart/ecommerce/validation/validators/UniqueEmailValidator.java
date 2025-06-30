package com.cakmart.ecommerce.validation.validators;

import com.cakmart.ecommerce.repository.UserRepository;
import com.cakmart.ecommerce.validation.annotations.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null || email.isBlank()) return true;
        return !userRepository.existsByEmail(email);
    }
}
