package com.solutions.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "login")
    @NotBlank
    private String login;

    @Column(name = "password")
    @NotBlank
    private String password;
}
