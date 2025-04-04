package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.models.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LearnerRepository extends JpaRepository<Learner, Long> {
    @Override
    Optional<Learner> findById(Long aLong);

    Optional<Learner> findByName(String name);

}
