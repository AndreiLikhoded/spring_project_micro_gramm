package com.example.boot_project.dto;

import com.example.boot_project.entity.Comment;
import com.example.boot_project.entity.Like;
import com.example.boot_project.entity.Publication;
import com.example.boot_project.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class CommentDTO {
    public static CommentDTO from(Comment comment) {
        return builder()
                .id(comment.getId())
                .commentText(comment.getCommentText())
                .dateComment(comment.getDateComment())
                .userId(comment.getUserId())
                .build();
    }

    private Long id;
    private String commentText;
    private LocalDateTime dateComment;
    private Long userId;


}
