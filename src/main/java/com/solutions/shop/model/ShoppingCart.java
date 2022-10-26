package com.solutions.shop.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import java.util.Collection;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.List;

@Data
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "customer_id")
    @NotNull
    @OneToMany (mappedBy="customer_id", fetch=FetchType.EAGER)
    private Integer customerId;

    @Column(name = "confirmed")
    private Boolean confirmed;
}
