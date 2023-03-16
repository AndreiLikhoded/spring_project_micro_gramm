package com.example.boot_project.entity;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Subscriber {
    private User userSubscriberId;
    private User subscriberTo;
    private LocalDateTime dateSubscribe;


    public Subscriber(User userSubscriberId, User subscriberTo, LocalDateTime dateSubscribe) {
        this.userSubscriberId = userSubscriberId;
        this.subscriberTo = subscriberTo;
        this.dateSubscribe = dateSubscribe;
    }
}
