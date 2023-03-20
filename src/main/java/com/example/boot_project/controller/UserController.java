package com.example.boot_project.controller;

import com.example.boot_project.dto.PublicationDTO;
import com.example.boot_project.dto.SubscribeDTO;
import com.example.boot_project.dto.UserDTO;
import com.example.boot_project.service.PublicationService;
import com.example.boot_project.service.SubscriberService;
import com.example.boot_project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;
    private final PublicationService publicationService;
    private final SubscriberService subscriberService;

    public UserController(UserService userService, PublicationService publicationService, SubscriberService subscriberService) {
        this.userService = userService;
        this.publicationService = publicationService;
        this.subscriberService = subscriberService;
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findUsers();
    }

    @GetMapping("/{userLogin}")
    public UserDTO getUserLogin(@PathVariable String userLogin) {
        return userService.findOne(userLogin);
    }

    @GetMapping("/{userName}")
    public UserDTO getUserName(@PathVariable String userName) {
        return userService.findName(userName);
    }

    @GetMapping("/{userEmail}")
    public UserDTO getUserEmail(@PathVariable String userEmail) {
        return userService.findEmail(userEmail);
    }

    @GetMapping("/{userId}/publications")
    public List<PublicationDTO> findPublications(@PathVariable Long userId) {
        return publicationService.findPublications(userId);
    }
    @GetMapping("/{userId}/subscriber")
    public List<SubscribeDTO>findSubcribers(@PathVariable Long subscriberId){
    return subscriberService.findSubscribers(subscriberId);

    }
}
