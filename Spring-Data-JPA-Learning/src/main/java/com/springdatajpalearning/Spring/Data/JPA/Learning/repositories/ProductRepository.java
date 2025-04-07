package com.springdatajpalearning.Spring.Data.JPA.Learning.repositories;

import com.springdatajpalearning.Spring.Data.JPA.Learning.models.models2.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
