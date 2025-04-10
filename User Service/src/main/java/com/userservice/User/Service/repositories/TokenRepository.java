package com.userservice.User.Service.repositories;

import com.userservice.User.Service.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

   // @Override
    Token save(Token token);


    //select * from token where value = <> and is deleted =false;

     Optional<Token> findByValueAndDeleted(String value, boolean Deleted);


}
