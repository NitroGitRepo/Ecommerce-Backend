package com.ecommerce.productservice.commons;

import com.ecommerce.productservice.dtos.UserDto;
import org.hibernate.annotations.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationCommons {


    public UserDto validateToken(String token){
        //call userService validatetoken api to validate
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDto> response = restTemplate.postForEntity("http://localhost:9091/user/validate/"+token, null, UserDto.class);

        if(response.getBody() == null){
            //token is invalid
            return null;
        }

        return  response.getBody();

    }
}
