package com.userservice.User.Service.Dtos;

import com.userservice.User.Service.models.Role;
import com.userservice.User.Service.models.User;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    @ManyToMany
    private List<Role> roles;
    private boolean isEmailVerified;

    public static UserDto from(User user){
          UserDto userDto = new UserDto();
          userDto.setEmail(user.getEmail());
          userDto.setName(user.getName());
          userDto.setEmailVerified(user.isEmailVerified());
          userDto.setRoles(user.getRoles());
          return userDto;
    }
}
