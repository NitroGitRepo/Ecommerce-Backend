package com.userservice.User.Service.services;

import com.userservice.User.Service.exception.InvalidPasswordException;
import com.userservice.User.Service.exception.InvalidTokenException;
import com.userservice.User.Service.models.Token;
import com.userservice.User.Service.models.User;
import com.userservice.User.Service.repositories.TokenRepository;
import com.userservice.User.Service.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private TokenRepository tokenRepository;
    UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, TokenRepository tokenRepository){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository = tokenRepository;
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
    public Token login(String email, String password) throws InvalidPasswordException {

//         1.check if user exist with the given email or not
//         2.If not throw an exception or redirect user to signup.
//         3.If user exist then compare the incoming password with the password store in database
//         4.If password matches then login successfull and return a new token.

           Optional<User> optionalUser = userRepository.findByEmail(email);

           if(optionalUser.isEmpty()){
               //user with given email does not exist
               return null;
           }

           User user = optionalUser.get();
           if(bCryptPasswordEncoder.matches(password, user.getHashedPassword()) != true){
               //throw exception
               throw new InvalidPasswordException("Please Enter Correct Password");
           }

           //if password correct login successfull and generate a new token
           Token token = generateToken(user);
           return tokenRepository.save(token);

    }

    private Token generateToken(User user){
        LocalDate currentTime = LocalDate.now();
        LocalDate thirtyDayFromCurrentTime = currentTime.plusDays(30);

        Date expiryDate = Date.from(thirtyDayFromCurrentTime.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Token token = new Token();
        //token expirytime
        token.setToken_expiry(expiryDate);

        //token value is randomly generated string of 128 character
        token.setValue(RandomStringUtils.randomAlphanumeric(128));

        //set user
        token.setUser(user);

        return token;
    }

    //logout service method;
    public void  logout(String tokenValue) throws InvalidTokenException {

        //1.First validate is the given token present in the database as well is_deleted =  false
        Optional<Token> optionalToken = tokenRepository.findByValueAndDeleted(
                tokenValue, false
        );

        //if token not present throw exception
        if(optionalToken.isEmpty()){
               //Throw an exception
              throw  new InvalidTokenException("Invalid Token Passed");
        }

        Token token = optionalToken.get();
        token.setDeleted(true);

        System.out.println("TOKEN DETAILS "+token);
        tokenRepository.save(token);
        return;
    }

    public User validateToken(String tokenValue) throws InvalidTokenException {
       Optional<Token> optionalToken =  tokenRepository.findByValueAndDeleted(tokenValue, false);

       if(optionalToken.isEmpty()){
           throw new InvalidTokenException("Invalid Token Passed");
       }

       return  optionalToken.get().getUser();

    }
}
