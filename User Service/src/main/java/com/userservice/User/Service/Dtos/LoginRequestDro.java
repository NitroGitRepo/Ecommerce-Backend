package com.userservice.User.Service.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDro {
    private String email;
    private String password;
}
