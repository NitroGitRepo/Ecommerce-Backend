package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    @Override
    Optional<Instructor> findById(Long aLong);
    Optional<Instructor> findByName(String name);
}
