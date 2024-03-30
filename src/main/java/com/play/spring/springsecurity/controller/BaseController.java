package com.play.spring.springsecurity.controller;

import com.play.spring.springsecurity.security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaseController {

    @GetMapping("/greet")
    public ResponseEntity<String> greetings(@RequestParam String name){

        return ResponseEntity.ok("Hello, " + name);
    }

    @GetMapping("/jwt")
    public String checkJwt(@AuthenticationPrincipal UserPrincipal principal){

        return "jwd is working finally " + principal.getUsername() + " " + principal.getEmail() + " " + principal.getUserId() ;
    }

}
