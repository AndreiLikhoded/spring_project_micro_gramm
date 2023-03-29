package com.example.boot_project.dto;

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

public class LikeDTO {
    public static LikeDTO from(Like like) {
        return builder()
                .id(like.getId())
                .userId(like.getUserId())
                .publicationId(like.getPublicationId())
                .dateOfLike(like.getDateOfLike())
                .build();
    }

    private Long id;
    private Long userId;
    private Long publicationId;
    private LocalDateTime dateOfLike;

}
