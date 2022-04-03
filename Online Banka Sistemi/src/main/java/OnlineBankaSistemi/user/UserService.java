package com.example.patika.user;

import com.example.patika.bank.Bank;
import com.example.patika.bank.BankDto;
import com.example.patika.bank.BankRepository;
import com.example.patika.common.MessageResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    BankRepository bankRepository;

    public UserService(UserDto userRepository, BankDto bankRepository) {
        this.userRepository = userRepository;
        this.bankRepository = bankRepository;
    }

    MessageResponse register(User user) {
        return userRepository.addUser(user);
    }

    MessageResponse login(String tc, String password) {
        User user = userRepository.getUser(tc);

        if(user == null) {
            return new MessageResponse("Error", "Wrong TC or Password");
        }

        if (user.getPassword().equals(password)) {
            return new MessageResponse("Success", "Logged in");
        } else {
            return new MessageResponse("Error", "Wrong TC or Password");
        }
    }

    MessageResponse send(String senderTc, String receiverTc, Double amount) {
        User sender = userRepository.getUser(senderTc);
        User receiver = userRepository.getUser(receiverTc);

        if(sender == null || receiver == null) {
            return new MessageResponse("Error", "Users could not found");
        }

        if(sender.getBalance() < amount) {
            return new MessageResponse("Error","There is not enough balance");
        }

        sender.setBalance(sender.getBalance()- amount);
        receiver.setBalance(receiver.getBalance() + amount);

        return new MessageResponse("Success", "The amount is sent");

    }

    MessageResponse payCredit(String tc, Double amount) {
        User user = userRepository.getUser(tc);

        if(user == null ) {
            return new MessageResponse("Error", "User could not found");
        }

        if(user.getBalance() < amount) {
            return new MessageResponse("Error","There is not enough balance");
        }

        Bank bank = bankRepository.getBank();

        user.setBalance(user.getBalance()-amount);
        bank.setBankAmount(bank.getBankAmount() + amount);

        return new MessageResponse("Success", "The amount is paid");
    }

    MessageResponse payCreditExtres(String tc, Double amount) {
        User user = userRepository.getUser(tc);

        if(user == null ) {
            return new MessageResponse("Error", "User could not found");
        }

        if(user.getBalance() < amount) {
            return new MessageResponse("Error","There is not enough balance");
        }

        Bank bank = bankRepository.getBank();

        user.setBalance(user.getBalance()-amount);
        bank.setBankAmount(bank.getBankAmount() + amount);

        return new MessageResponse("Success", "The amount is paid");
    }
}
