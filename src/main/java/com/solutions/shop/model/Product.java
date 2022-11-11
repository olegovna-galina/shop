package com.solutions.shop.model;

import lombok.Data;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "description")
    @NotBlank
    private String description;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @Column(name = "brand")
    @NotBlank
    private String brand;

    @Column(name = "category")
    @NotBlank
    private String category;

    public Product(Integer productId, String name, String description, BigDecimal price, String brand, String category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.brand = brand;
        this.category = category;
    }

    /* Implementing With a Join Table in JPA */
    @ManyToMany(mappedBy = "products")
    private Set<ShoppingCart> shoppingCarts;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
