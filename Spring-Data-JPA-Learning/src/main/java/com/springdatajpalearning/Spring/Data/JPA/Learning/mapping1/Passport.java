package com.springdatajpalearning.Spring.Data.JPA.Learning.mapping1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Passport {
    @Id
    private int passportId;


    private String passportName;

    @OneToOne(mappedBy = "passport")
    private Person person;
}
