package com.cakmart.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public String helloRoot() {
        return "Aman Masse";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Check") String name) {
        return String.format("Hello %s!", name);
    }
}
