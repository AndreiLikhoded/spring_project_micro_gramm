package com.example.boot_project.controller;

import com.example.boot_project.dto.PublicationDTO;
import com.example.boot_project.service.PublicationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publications")

public class PublicationController {

    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PublicationDTO addReview(@RequestBody PublicationDTO publicationData) {
        return publicationService.addPublication(publicationData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable Long id) {
        if (publicationService.deletePublication(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }
}
