package com.example.patika.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class LoginRequest {
    @NotNull
    private String tc;
    @NotNull
    private String password;
}
