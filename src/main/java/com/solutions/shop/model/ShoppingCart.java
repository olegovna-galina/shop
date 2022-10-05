package com.solutions.shop.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "customer_id")
    @NotNull
    private Integer customerId;

    @Column(name = "confirmed_y_n")
    private Boolean confirmedYN;
}
