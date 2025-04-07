package com.springdatajpalearning.Spring.Data.JPA.Learning.repositories;

import com.springdatajpalearning.Spring.Data.JPA.Learning.models.Student;
import com.springdatajpalearning.Spring.Data.JPA.Learning.models1.Student1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student1, Integer> {
}
