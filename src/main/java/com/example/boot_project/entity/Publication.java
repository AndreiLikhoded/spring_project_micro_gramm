package com.example.boot_project.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Publication {

    private Comment comment;
    private String image;
    private String description;
    private LocalDateTime dataOfPublication;

    public Publication(String image, String description, LocalDateTime dataOfPublication) {
        this.image = image;
        this.description = description;
        this.dataOfPublication = dataOfPublication;
    }
}
