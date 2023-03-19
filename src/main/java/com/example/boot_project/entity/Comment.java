package com.example.boot_project.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;


@Data
public class Comment {

    private Long id;
    private String commentText;
    private LocalDateTime dateComment;

    private Set<User> user;

//    public Comment(String commentText, LocalDateTime dateComment) {
//        this.commentText = commentText;
//        this.dateComment = dateComment;
//    }
}
