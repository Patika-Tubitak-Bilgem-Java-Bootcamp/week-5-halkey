package com.example.patika.user;

import com.example.patika.common.MessageResponse;
import com.example.patika.requests.LoginRequest;
import com.example.patika.requests.PayCreditRequest;
import com.example.patika.requests.SendRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/register")
    public MessageResponse register(@RequestBody @Valid User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public MessageResponse login(@RequestBody @Valid LoginRequest request) {
        return userService.login(request.getTc(), request.getPassword());
    }

    @PostMapping("/payCredit")
    public MessageResponse payCredit(@RequestBody @Valid PayCreditRequest request) {
        return userService.payCredit(request.getTc(), request.getAmount());
    }

    @PostMapping("/payExtress")
    public MessageResponse payExtress(@RequestBody @Valid PayCreditRequest request) {
        return userService.payCreditExtres(request.getTc(), request.getAmount());
    }

    @PostMapping("/send")
    public MessageResponse send(@RequestBody @Valid SendRequest request) {
        return userService.send(request.getSenderTc(),request.getReceiverTc(),request.getAmount());
    }
}
