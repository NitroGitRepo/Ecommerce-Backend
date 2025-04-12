package com.userservice.User.Service.controllers;

import com.userservice.User.Service.Dtos.LoginRequestDro;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/s")
public class SampleComtroller {

    @PostMapping("/valid")
    public String valid(@RequestBody LoginRequestDro loginRequestDro){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();


        System.out.println("USERNAME "+userName);
        return "VLID USER";
    }
}

