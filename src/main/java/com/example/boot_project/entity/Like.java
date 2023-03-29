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
public class Like {

    private Long id;
    private Long userId;
    private Long publicationId;
    private LocalDateTime dateOfLike;
}


