package com.example.patika.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class SendRequest {
    @NotNull
    private String senderTc;
    @NotNull
    private String receiverTc;
    @NotNull
    private Double amount;
}
