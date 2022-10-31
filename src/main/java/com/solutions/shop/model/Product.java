package com.solutions.shop.model;

import lombok.Data;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

    /* Implementing With a Join Table in JPA */
    @OneToOne(mappedBy = "product")
    private ShoppingCart shoppingCart;
}
