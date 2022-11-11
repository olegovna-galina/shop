package com.solutions.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table(name = "shopping_cart")
@AllArgsConstructor
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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_product",
            joinColumns =
                    { @JoinColumn(name = "order_id", referencedColumnName = "order_id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "product_id", referencedColumnName = "product_id") })
    private Set<Product> products;

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
