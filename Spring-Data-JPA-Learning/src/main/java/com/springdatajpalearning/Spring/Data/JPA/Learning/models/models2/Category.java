package com.springdatajpalearning.Spring.Data.JPA.Learning.models.models2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Category_Table")
public class Category {

    @Id
    private String cId;
    private String title;

    @ManyToMany(mappedBy = "categoryList", cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();
}
