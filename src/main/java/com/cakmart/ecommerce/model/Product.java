package com.cakmart.ecommerce.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String description;

    String excerpt;

//    UUID categoryId;

    Double price;

    Integer stock;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String productUrl;

//    private UUID companyId;

    private boolean isAvailable;

    private Double costPrice;

    @Column(columnDefinition = "TEXT")
    private String internalNotes;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String updatedBy;

    private String createdBy;




    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
