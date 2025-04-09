package com.userservice.User.Service.controllers;

import com.userservice.User.Service.Dtos.LogOutRequestDto;
import com.userservice.User.Service.Dtos.LoginRequestDro;
import com.userservice.User.Service.Dtos.SignUpRequestDto;
import com.userservice.User.Service.Dtos.UserDto;
import com.userservice.User.Service.models.Token;
import com.userservice.User.Service.models.User;
import com.userservice.User.Service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    UserController(UserService userService){
//        this.userService =  userService;
//    }

  @PostMapping("/signup") //localhost:8080/users/signup
  public UserDto signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        User user = userService.signUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword(), signUpRequestDto.getName());

        //get UserDto from user;
        return  UserDto.from(user);
  }

  @PostMapping("/login") //localhost:8080/users/login
  public Token login(@RequestBody LoginRequestDro loginRequestDro){
      return null;
  }

  @PostMapping("/logout") //localhost:8080/users/logout
  public ResponseEntity<Void> logout(@RequestBody LogOutRequestDto logOutRequestDto){
        return null;
  }
}
