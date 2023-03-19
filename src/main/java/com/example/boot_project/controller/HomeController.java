package com.example.boot_project.controller;

import com.example.boot_project.dao.UserDao;
import com.example.boot_project.entity.User;
import com.example.boot_project.service.HomeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService service;
    private final UserDao userDao;

    @GetMapping("/connect")
    public ResponseEntity<String> connection(){
        return new ResponseEntity<>(service.connect(), HttpStatus.OK);
    }


    @PostMapping("/createCommentTable")
    public ResponseEntity<String> createCommentTable(){
        return new ResponseEntity<>(service.shouldCreatePublicationsCommentsLikesSubscribesTables(), HttpStatus.OK);
    }

//    @GetMapping("/findByLogin")
//    public ResponseEntity<User> findByLogin(@PathVariable String profileId){
//        return new ResponseEntity<>(service.findUserByProfile(profileId), HttpStatus.OK);
//    }
//
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
