package com.userservice.User.Service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
@Entity
public class Token extends BaseModel{
    private String value;

    @ManyToOne
    private User user;
    private Date token_expiry;
}
