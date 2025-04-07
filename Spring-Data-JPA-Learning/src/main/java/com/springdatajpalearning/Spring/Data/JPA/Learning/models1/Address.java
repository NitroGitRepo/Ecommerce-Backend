package com.springdatajpalearning.Spring.Data.JPA.Learning.models1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Address_Table")
public class Address {
    @Id
    private int addressId;
    private String street;
    private String city;
    private String country;


    @ManyToOne
    @JoinColumn(name = "student1_id")
    private Student1 student1;

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
