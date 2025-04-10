package com.userservice.User.Service.controllers;

import com.userservice.User.Service.Dtos.*;
import com.userservice.User.Service.exception.InvalidPasswordException;
import com.userservice.User.Service.exception.InvalidTokenException;
import com.userservice.User.Service.models.Token;
import com.userservice.User.Service.models.User;
import com.userservice.User.Service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
  public LogInResponseDto login(@RequestBody LoginRequestDro loginRequestDro) throws InvalidPasswordException {
      Token token = userService.login(loginRequestDro.getEmail(), loginRequestDro.getPassword());
      LogInResponseDto responseDto = new LogInResponseDto();
      responseDto.setToken(token);
      return responseDto;
  }


  @PostMapping("/logout") //localhost:8080/users/logout
  public ResponseEntity<Void> logout(@RequestBody LogOutRequestDto logOutRequestDto){
      ResponseEntity<Void> responseEntity = null;
      try {
          userService.logout(logOutRequestDto.getToken());
          responseEntity = new ResponseEntity<>(HttpStatus.OK);
      } catch (Exception e) {
           responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
      return responseEntity;
  }


  @PostMapping("/validate/{token}")
  public UserDto validateToken(@PathVariable("token") String tokenValue){
      System.out.println("Validate Controller");
      try {
          User user = userService.validateToken(tokenValue);
          return  UserDto.from(user);
      } catch (InvalidTokenException e) {
          throw new RuntimeException(e);
      }
  }

  @GetMapping("/sample")
  public void sampleAPI(){
      System.out.println("GOT A API REQUEST");
  }
}
