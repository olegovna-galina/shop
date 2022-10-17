package com.solutions.shop.model;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    // @Column(name = "product_id")
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

    @ManyToMany
    @JoinTable (name="order_product",
            joinColumns=@JoinColumn (name="product_id"),
            inverseJoinColumns=@JoinColumn(name="order_id"))
    private List<ShoppingCart> orders;
}
