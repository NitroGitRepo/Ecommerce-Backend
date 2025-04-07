package com.springdatajpalearning.Spring.Data.JPA.Learning.repositories;

import com.springdatajpalearning.Spring.Data.JPA.Learning.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
}
