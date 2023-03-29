package com.example.boot_project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
    private Long id;
    private Long userId;
    private String image;
    private String description;
    private LocalDateTime dateOfPublication;
}
