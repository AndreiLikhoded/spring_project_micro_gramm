package com.example.boot_project.entity;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class Like {

    private Long id;
    private Set<User> userId;
    private Publication likeAim;
    private LocalDateTime dateOfLike;

//    public Like(Set<User> userId, Publication likeAim, LocalDateTime dateOfLike) {
//        this.userId = userId;
//        this.likeAim = likeAim;
//        this.dateOfLike = dateOfLike;
//    }
}


