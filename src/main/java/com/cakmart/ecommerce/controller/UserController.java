package com.cakmart.ecommerce.controller;


import com.cakmart.ecommerce.model.User;
import com.cakmart.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Get All User
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // Get user by
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }

    // POST create new user
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    // PUT update user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails){
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setUpdatedBy(userDetails.getUpdatedBy());

        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
