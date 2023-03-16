package com.example.boot_project.entity;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Comment {
    private String commentText;
    private LocalDateTime dateComment;

    private User user;

    public Comment(String commentText, LocalDateTime dateComment) {
        this.commentText = commentText;
        this.dateComment = dateComment;
    }
}
