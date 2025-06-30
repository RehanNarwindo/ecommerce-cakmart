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
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);

    }


    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }

        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        product.setCostPrice(productDetails.getCostPrice());
        product.setProductUrl(product.getProductUrl());
        product.setExcerpt(product.getExcerpt());
        product.setInternalNotes((product.getInternalNotes()));
        product.setUpdatedAt(productDetails.getUpdatedAt());
        product.setUpdatedBy(productDetails.getUpdatedBy());

        return productRepository.save(product);
    }


    }


