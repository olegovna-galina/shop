package com.solutions.shop.model;

import javax.persistence.*;
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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="users_seq")
    @SequenceGenerator(name="users_seq", sequenceName="seq_user", allocationSize=1)
    @Column(name = "user_id", updatable = false, nullable = false)
    private Integer userId;

    @Column(name = "login")
    @NotBlank
    private String login;

    @Column(name = "password")
    @NotBlank
    private String password;
}
