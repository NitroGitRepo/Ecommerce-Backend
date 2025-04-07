package com.ecommerce.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity(name = "Instructor_Test_Table")
public class Instructor extends User{

    private  double Salary;
    private  String skill;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Batch> batch;
}
