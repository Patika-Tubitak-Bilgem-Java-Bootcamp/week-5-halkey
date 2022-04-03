package com.example.patika.bank;

import org.springframework.stereotype.Repository;

@Repository
public class BankDto implements  BankRepository {

    Bank bank;

    public BankDto() {
        this.bank  = new Bank("Bank", 0.0);;
    }

    @Override
    public Bank getBank() {
        return bank;
    }
}
