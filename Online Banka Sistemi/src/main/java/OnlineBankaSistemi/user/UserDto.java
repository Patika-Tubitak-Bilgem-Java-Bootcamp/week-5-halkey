package com.example.patika.user;

import com.example.patika.common.MessageResponse;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDto implements UserRepository{

    Set<User> users= new HashSet<>();

    @Override
    public MessageResponse addUser(User user) {
        if (users.contains(user)) {
            return new MessageResponse("Error", "This tc is used already");
        } else if(user.getPassword().contains(user.getTc())) {
            return new MessageResponse("Error", "Password cannot include TC");
        }
        else {
            users.add(user);
            return new MessageResponse("Success", "Successful register");
        }
    }

    @Override
    public User getUser(String tc) {
        List<String> tcList = users.stream().map( (user) -> user.getTc()).toList();
        if (tcList.contains(tc)) {
            return users.stream().filter(user -> user.getTc().equals(tc)).toList().get(0);
        } else {
            return null;
        }
    }
}
