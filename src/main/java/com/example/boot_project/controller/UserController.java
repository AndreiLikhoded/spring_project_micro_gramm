package com.example.boot_project.controller;

import com.example.boot_project.dto.UserDto;
import com.example.boot_project.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(){
        return new ResponseEntity<>(service.shouldCreateTable(), HttpStatus.OK);
    }

    @PostMapping("/createUserTable")
    public ResponseEntity<String> createUserTable(){
        return new ResponseEntity<>(service.shouldCreateUserTable(), HttpStatus.OK);
    }


    @GetMapping("/{email}")
    public UserDto getEmail(@PathVariable String email) {
        return userService.emailSearch(email);
    }



}
