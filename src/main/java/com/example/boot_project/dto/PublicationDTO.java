package com.example.boot_project.dto;

import com.example.boot_project.dao.PublicationDao;
import com.example.boot_project.entity.Comment;
import com.example.boot_project.entity.Publication;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class PublicationDTO {
    private final PublicationDao publicationDao;

    public static PublicationDTO from(Publication publication) {
        return builder()
                .id(publication.getId())
                .userId(publication.getUserId())
                .comment(publication.getComment())
                .image(publication.getImage())
                .description(publication.getDescription())
                .dateOfPublication(publication.getDateOfPublication())
                .build();
    }

    private Long id;
    private Long userId;
    private Comment comment;
    private String image;
    private String description;
    private LocalDateTime dateOfPublication;


}
