package com.example.boot_project.controller;

import com.example.boot_project.entity.Customer;
import com.example.boot_project.service.HomeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService service;
    @GetMapping("/connect")
    public ResponseEntity<String> connection(){
        return new ResponseEntity<>(service.connect(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(){
        return new ResponseEntity<>(service.shouldCreateTable(), HttpStatus.OK);
    }

    @PostMapping("/createUserTable")
    public ResponseEntity<String> createUserTable(){
        return new ResponseEntity<>(service.shouldCreateUserTable(), HttpStatus.OK);
    }

    @PostMapping("/createPublicationsTable")
    public ResponseEntity<String> createPublicationsTable(){
        return new ResponseEntity<>(service.shouldCreatePublicationsTable(), HttpStatus.OK);
    }



    @GetMapping("/select")
    public ResponseEntity<String> select(){
        return new ResponseEntity<>(service.shouldSelectData(), HttpStatus.OK);
    }

    @GetMapping("/hikari")
    public ResponseEntity<String> hikari(){
        return new ResponseEntity<>(service.getDataSourceConn(), HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<>(service.getCustomers(), HttpStatus.OK);
    }
}
