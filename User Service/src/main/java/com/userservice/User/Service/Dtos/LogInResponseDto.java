package com.userservice.User.Service.Dtos;

import com.userservice.User.Service.models.Token;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInResponseDto {

    private Token token;
}
