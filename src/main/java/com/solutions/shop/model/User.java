package com.solutions.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    // @Column(name = "user_id")
    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="user_id")
    private Integer userId;

    @Column(name = "login")
    @NotBlank
    private String login;

    @Column(name = "password")
    @NotBlank
    private String password;

    public User() {
    }

    public User(Integer userId, String login, String password) {
        this.userId = userId;
        this.login = login;
        this.password = password;
    }

    public Integer getId() {
        return userId;
    }
}
