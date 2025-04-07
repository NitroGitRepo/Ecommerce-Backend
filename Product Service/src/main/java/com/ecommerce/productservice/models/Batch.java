package com.ecommerce.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Batch_Test_Table")
public class Batch extends User{
    @Id
    @Column(name = "Batch_Name")
    private String name;

    @Column(name = "Batch_Strength")
    private Integer strength;
}

