package com.example.patika.bank;

import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository {

    Bank getBank();
}
