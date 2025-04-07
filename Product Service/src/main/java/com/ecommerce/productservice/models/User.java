package com.ecommerce.productservice.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity(name = "ecommerce_user")
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @Id
    @GeneratedValue
    @Column(name = "User Id")
    private UUID id;

    @Column(name = "User Name")
    private String name;

    @Column(name = "User Email")
    private String email;


}
