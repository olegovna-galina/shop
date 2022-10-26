package com.solutions.shop.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private Integer customerId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "customer_id")
    private User user;

    @Column(name = "first_name")
    //@NotBlank
    private String firstName;

    @Column(name = "last_name")
    //@NotBlank
    private String lastName;

    @Column(name = "address")
    //@NotBlank
    private String address;

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }
}
