package com.example.boot_project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private Long id;
    private String commentText;
    private LocalDateTime dateComment;

    private Long userId;
    private Long publicationId;

}
