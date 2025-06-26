package com.cakmart.ecommerce.controller;


import com.cakmart.ecommerce.model.Product;
import com.cakmart.ecommerce.model.User;
import com.cakmart.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllUsers(){
        return productRepository.findAll();
    }

    // Get user by
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id).orElse(null);
    }



    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

}
