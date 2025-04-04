package com.ecommerce.productservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "Instructor_Test_Table")
public class Instructor extends User{

    private  double Salary;
    private  String skill;


}
