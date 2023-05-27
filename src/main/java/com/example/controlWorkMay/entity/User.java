package com.example.controlWorkMay.entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "usr")
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25)
    private String name;

    @Column(length = 25)
    private String email;

    @Column(length = 25)
    private String login;

    @Column(length = 16)
    private String password;

    private Boolean enable;

    @Enumerated(EnumType.STRING)
    private UserRole role;

}
