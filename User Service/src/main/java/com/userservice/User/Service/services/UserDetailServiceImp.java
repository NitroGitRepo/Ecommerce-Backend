package com.userservice.User.Service.services;

import com.userservice.User.Service.models.User;
import com.userservice.User.Service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailServiceImp implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("USER DETAILS LOAD FUNCRION "+ username);
        Optional<User> user = userRepository.findByEmail(username);
        User user1 = user.get();
        System.out.println("USER OBJECT" +user1);
        if (user != null){
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user1.getEmail())
                    .password(user1.getHashedPassword())
                    .roles("")
                    .build();

        }
        else{
            throw new RuntimeException("user name not found");
        }

    }
}
