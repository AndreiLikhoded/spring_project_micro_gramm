package com.example.boot_project.controller;

import com.example.boot_project.dto.UserDTO;
import com.example.boot_project.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findUsers();
    }

    @GetMapping("/{userLogin}")
    public UserDTO getUserLogin(@PathVariable String userLogin) {
        return userService.findOne(userLogin);
    }

    @GetMapping("/{userName}")
    public UserDTO getUserName(@PathVariable String userName) {
        return userService.findName(userName);
    }

    @GetMapping("/{userEmail}")
    public UserDTO getUserEmail(@PathVariable String userEmail) {
        return userService.findEmail(userEmail);
    }


}
