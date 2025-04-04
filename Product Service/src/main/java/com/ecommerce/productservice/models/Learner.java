package com.ecommerce.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Learner_Test_Table")
public class Learner extends User{

    private String university;
    private double psp;
}
