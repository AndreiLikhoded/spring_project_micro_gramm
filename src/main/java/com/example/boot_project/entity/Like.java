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
    private Set<User> userId;
    private Publication likeAim;
    private LocalDateTime dateOfLike;

//    public Like(Set<User> userId, Publication likeAim, LocalDateTime dateOfLike) {
//        this.userId = userId;
//        this.likeAim = likeAim;
//        this.dateOfLike = dateOfLike;
//    }
}


