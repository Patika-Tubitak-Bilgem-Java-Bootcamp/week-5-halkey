package com.example.patika.user;

import com.example.patika.common.MessageResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

     MessageResponse addUser(User user);

     User getUser(String tc);


}
