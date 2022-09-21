package com.solutions.shop.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "log_in")
    @NotBlank
    String logId;

    @Column(name = "password")
    @NotBlank
    String password;
/*
    @Column(name = "role")
    String role;
*/
    public @NotBlank String getId() {
        return logId;
    }

    /* GET SET methods are generated by lombok. All fields are private. */
}
