package com.example.patika.bank;


import com.example.patika.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Bank {

    private String name;

    private Set<User> users = new HashSet<>();

    private Double bankAmount;

    public Bank(String name,Double bankAmount) {
        this.name = name;
        this.bankAmount = bankAmount;
    }
}
