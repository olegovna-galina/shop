package com.solutions.shop.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
@RequiredArgsConstructor
@Setter
public class Product {
    @Id
    @Column(name = "product_id")
    @NonNull
    private Integer productId;

    @Column(name = "name")
    @NotBlank
    @NonNull
    private String name;

    @Column(name = "description")
    @NotBlank
    @NonNull
    private String description;

    @Column(name = "price")
    @NotNull
    @NonNull
    private BigDecimal price;

    @Column(name = "brand")
    @NotBlank
    @NonNull
    private String brand;

    @Column(name = "category")
    @NotBlank
    @NonNull
    private String category;

    /* Implementing With a Join Table in JPA */
    @ManyToMany(mappedBy = "products")
    private Set<ShoppingCart> shoppingCarts;
}
