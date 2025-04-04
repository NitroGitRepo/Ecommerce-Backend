package com.ecommerce.productservice.repository;

import com.ecommerce.productservice.models.User;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.*;

import java.util.Optional;

@Server
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long id);

    Optional<User> findByName(String name);

     List<User> findAllByNameEndingWith(String suffix);

     //List<User> getAllUser();
}
