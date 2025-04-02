package com.ecommerce.productservice.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ecommerce_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "User Id")
    private Long id;

    @Column(name = "User Name")
    private String name;

    @Column(name = "User Email")
    private String email;


}
