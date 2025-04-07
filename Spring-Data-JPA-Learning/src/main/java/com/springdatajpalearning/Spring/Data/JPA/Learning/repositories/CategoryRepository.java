package com.springdatajpalearning.Spring.Data.JPA.Learning.repositories;

import com.springdatajpalearning.Spring.Data.JPA.Learning.models.models2.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
