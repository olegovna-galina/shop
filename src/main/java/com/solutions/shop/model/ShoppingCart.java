package com.solutions.shop.model;

import lombok.Data;

import javax.persistence.*;
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

    @Column(name = "confirmed")
    private Boolean confirmed;

    /* The customer_id column is the foreign key to customer.customer_id */
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable=false, updatable=false)
    private Customer customer;

    /* Implementing With a Join Table in JPA */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "order_product",
            joinColumns =
                    { @JoinColumn(name = "order_id", referencedColumnName = "order_id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "product_id", referencedColumnName = "product_id") })
    private Product product;
}
