package com.play.spring.springsecurity.controller;

import com.play.spring.springsecurity.security.JwtIssuer;
import com.play.spring.springsecurity.model.LoginRequest;
import com.play.spring.springsecurity.model.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JwtIssuer jwtIssuer;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        var token = jwtIssuer.issuer(1, request.getEmail(), List.of("USER"));
        return  LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
