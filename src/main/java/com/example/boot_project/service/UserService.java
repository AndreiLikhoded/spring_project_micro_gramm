package com.example.boot_project.service;


import com.example.boot_project.dao.UserDao;

import com.example.boot_project.dto.UserDTO;
import com.example.boot_project.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserDTO> findUsers() {
        var userList = userDao.findAll();
        return userList.stream().map(UserDTO::from).collect(Collectors.toList());
    }

    public UserDTO findOne(String userLogin) {
        var user = userDao.findByLogin(userLogin)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user by login: " + userLogin));
        return UserDTO.from(user);


    }
    public UserDTO findName(String userName) {
        var user = userDao.findByName(userName)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user by name: " + userName));
        return UserDTO.from(user);


    }

    public UserDTO findEmail(String userEmail) {
        var user = userDao.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user by email: " + userEmail));
        return UserDTO.from(user);


    }


}
