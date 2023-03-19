package com.example.boot_project.dto;

import com.example.boot_project.dao.UserDao;
import com.example.boot_project.entity.User;
import lombok.*;
import java.util.Set;


@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class UserDto {
    private final UserDao userDao;




}
