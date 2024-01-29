package com.pailsail.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods.
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "new_price")
    private Double newPrice;

    @Column(name = "old_price")
    private Double oldPrice;

    // Default constructor
    public Product() {
    }

    // All arguments constructor
    public Product(Long id, String name, String category, String imageUrl, Double newPrice, Double oldPrice) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.newPrice = newPrice;
        this.oldPrice = oldPrice;
    }
}
