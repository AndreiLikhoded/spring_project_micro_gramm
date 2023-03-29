package com.example.boot_project.util;

import com.example.boot_project.dao.*;
import com.example.boot_project.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Configuration
public class DataBaseManipulation {
    @Bean
    CommandLineRunner run(UserDao userDao, CommentDao commentDao, LikeDao likeDao, PublicationDao publicationDao, SubscriberDao subscriberDao) {
        return (args) -> {
            userDao.createTable();
            commentDao.createTable();
            likeDao.createTable();
            publicationDao.createTable();
            subscriberDao.createTable();

            userDao.deleteAll();
            commentDao.deleteAll();
            likeDao.deleteAll();
            publicationDao.deleteAll();
            subscriberDao.deleteAll();

            List<User> users = Stream.generate(User::random)
                    .limit(10)
                    .collect(toList());
            userDao.saveAll(users);

        };
    }
}
