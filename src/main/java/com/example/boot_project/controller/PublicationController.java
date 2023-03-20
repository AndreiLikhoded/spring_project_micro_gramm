package com.example.boot_project.controller;

import com.example.boot_project.dto.LikeDTO;
import com.example.boot_project.dto.PublicationDTO;
import com.example.boot_project.service.LikeService;
import com.example.boot_project.service.PublicationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publications")

public class PublicationController {

    private final PublicationService publicationService;
    private final LikeService likeService;

    public PublicationController(PublicationService publicationService, LikeService likeService) {
        this.publicationService = publicationService;
        this.likeService = likeService;
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
    @GetMapping("/{publicationId}/likes")
    public List<LikeDTO> findLikes(@PathVariable Long likeId){
        return likeService.addLikes(likeId);
    }
}
