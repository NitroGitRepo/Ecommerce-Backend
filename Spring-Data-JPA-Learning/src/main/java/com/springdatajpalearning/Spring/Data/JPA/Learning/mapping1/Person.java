package com.springdatajpalearning.Spring.Data.JPA.Learning.mapping1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person {

    @Id
    private int personId;

    private int personName;

    @OneToOne
    @JoinColumn(name = "passport_id")
    private  Passport passport;
}
