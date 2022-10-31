package com.solutions.shop.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private Integer customerId;

    /* The customer_id column is the foreign key to user_id */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "user_id")
    private User user;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }
}
