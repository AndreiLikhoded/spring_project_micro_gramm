package com.example.boot_project.controller;

import com.example.boot_project.dao.UserDao;
import com.example.boot_project.entity.User;
import com.example.boot_project.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService service;
    private final UserDao userDao;

    @GetMapping("/connect")
    public ResponseEntity<String> connection(){
        return new ResponseEntity<>(service.connect(), HttpStatus.OK);
    }

    @PostMapping("/createUserTable")
    public ResponseEntity<String> createUserTable(){
        return new ResponseEntity<>(service.shouldCreateUserTable(), HttpStatus.OK);
    }

    @PostMapping("/createOtherUserTables")
    public ResponseEntity<String> createOtherUserTables(){
        return new ResponseEntity<>(service.shouldCreatePublicationsCommentsLikesSubscribesTables(), HttpStatus.OK);
    }

    @GetMapping("/findByLogin")
    public ResponseEntity<User> findByLogin(){
        return new ResponseEntity<>(service.findUserByProfile(), HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<User> findByName(){
        return new ResponseEntity<>(service.findUserByName(), HttpStatus.OK);
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<User> findByEmail(){
        return new ResponseEntity<>(service.findUserByEmail(), HttpStatus.OK);
    }


    @GetMapping("/select")
    public ResponseEntity<String> select(){
        return new ResponseEntity<>(service.shouldSelectData(), HttpStatus.OK);
    }

    @GetMapping("/hikari")
    public ResponseEntity<String> hikari(){
        return new ResponseEntity<>(service.getDataSourceConn(), HttpStatus.OK);
    }

}
