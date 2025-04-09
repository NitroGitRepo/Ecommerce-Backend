package com.ecommerce.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


@Getter
@Setter
@Entity(name = "Instructor_Test_Table")
public class Instructor extends User{

    private  double Salary;
    private  String skill;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    //@Fetch(FetchMode.JOIN)
    //@Fetch(FetchMode.SELECT)
    @Fetch(FetchMode.SUBSELECT)
    private List<Batch> batch;
}
