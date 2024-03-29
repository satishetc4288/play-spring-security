package com.play.spring.springsecurity.controller;

import org.springframework.http.ResponseEntity;
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
    public String checkJwt(){
        return "jwd is working finally";
    }

}
