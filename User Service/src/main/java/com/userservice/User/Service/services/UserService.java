package com.userservice.User.Service.services;

import com.userservice.User.Service.models.Token;
import com.userservice.User.Service.models.User;
import com.userservice.User.Service.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //sign up service method
    public User signUp(String email, String password, String name){

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            //user is already present in the db, so no need to sign up
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setHashedPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
        //return null;
    }

    //login in service method
    public Token login(String email, String password){
          return null;
    }

    //logout service method;
    public void  logout(Token token){
        return;
    }
}
