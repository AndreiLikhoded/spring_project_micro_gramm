package com.example.boot_project.dto;

import com.example.boot_project.dao.UserDao;
import com.example.boot_project.entity.Publication;
import com.example.boot_project.entity.User;
import lombok.*;


@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class UserDTO {
    private final UserDao userDao;

    public static UserDTO from(User user){
        return builder()
                .publication(user.getPublication())
                .name(user.getName())
                .login(user.getLogin())
                .email(user.getEmail())
                .age(user.getAge())
                .numberOfPublications(user.getNumberOfPublications())
                .numberOfSubscribers(user.getNumberOfSubscribers())
                .numberOfSubscribes(user.getNumberOfSubscribes())
                .build();
    }

    private Publication publication;
    private String name;
    private String login;
    private String email;
    private int age;
    private int numberOfPublications;
    private int numberOfSubscribes;
    private int numberOfSubscribers;



}
