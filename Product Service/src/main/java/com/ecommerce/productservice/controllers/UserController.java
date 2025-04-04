package com.ecommerce.productservice.controllers;

import com.ecommerce.productservice.dtos.CreateUserDto;
import com.ecommerce.productservice.dtos.UserDemoDto;
import com.ecommerce.productservice.models.Instructor;
import com.ecommerce.productservice.models.Learner;
import com.ecommerce.productservice.models.User;
import com.ecommerce.productservice.models.UserDemo;
import com.ecommerce.productservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //Api for storing user data
    @PostMapping("")
    public @ResponseBody User createUser(@RequestBody CreateUserDto user){
        return userService.createUser(user.getName(), user.getEmail());
    }

    //Api for stroring instructor data
    @PostMapping("/instructor")
    public Instructor createInstructor(@RequestBody UserDemoDto userDemoDto){
        return  userService.createInstructor(userDemoDto.getName(), userDemoDto.getEmail());
    }

    //Api for storing learner data
    @PostMapping("/learner")
    public Learner createLearner(@RequestBody CreateUserDto user){
        return  userService.createLearner(user.getName(), user.getEmail());
    }



    //Api to get user data
    @GetMapping("/{name}")
    public  @ResponseBody Optional<User> getUserByName(@PathVariable("name") String name){
        return userService.getUserByName(name);
    }

    //Api to get instructor data
    @GetMapping("/instructor/{name}")
    public  @ResponseBody Optional<Instructor> getInstructorByName(@PathVariable("name") String name){
        return userService.geInstructorByName(name);
    }

    //Api to get learner data
    @GetMapping("/learner/{name}")
    public @ResponseBody Optional<Learner> getLearnerByName(@PathVariable("name") String name){
        return userService.getLearnerByName(name);
    }


    @GetMapping("/id/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

//    @GetMapping("/")
//    public @ResponseBody List<User> getAllUser(){
//        return userService.getAllUser();
//    }
}
