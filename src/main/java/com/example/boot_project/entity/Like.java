package com.example.boot_project.entity;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Like {
    private User userId;
    private Publication likeAim;
    private LocalDateTime dateOfLike;

    public Like(User userId, Publication likeAim, LocalDateTime dateOfLike) {
        this.userId = userId;
        this.likeAim = likeAim;
        this.dateOfLike = dateOfLike;
    }
}


