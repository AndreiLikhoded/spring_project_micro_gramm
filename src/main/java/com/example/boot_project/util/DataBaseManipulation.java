package com.example.boot_project.util;

import com.example.boot_project.dao.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

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

        };
    }
}
