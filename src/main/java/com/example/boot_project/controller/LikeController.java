package com.example.boot_project.controller;


import com.example.boot_project.dto.LikeDTO;
import com.example.boot_project.service.LikeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")

public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public LikeDTO addLike(@RequestBody LikeDTO likeData) {
        return likeService.addLike(likeData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLike(@PathVariable Long id) {
        if (likeService.deleteLike(id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }

}
