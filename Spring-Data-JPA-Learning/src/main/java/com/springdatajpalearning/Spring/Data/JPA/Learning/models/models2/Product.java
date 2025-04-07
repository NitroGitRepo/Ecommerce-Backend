package com.springdatajpalearning.Spring.Data.JPA.Learning.models.models2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Product_Table")
public class Product {
    @Id
    private String pId;
    private String productName;


    @ManyToMany
    private List<Category> categoryList = new ArrayList<>();
}
