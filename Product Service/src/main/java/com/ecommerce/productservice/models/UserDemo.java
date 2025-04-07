package com.ecommerce.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
//@MappedSuperclass

@Entity(name = "user_demo_table")
public class UserDemo {
    @Id
    @GeneratedValue
    @Column(name = "User Id")
    private UUID id;

    @Column(name = "User Name")
    private String name;

    @Column(name = "User Email")
    private String email;
}
