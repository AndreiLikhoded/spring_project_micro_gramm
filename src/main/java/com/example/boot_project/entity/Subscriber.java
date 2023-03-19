package com.example.boot_project.entity;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class Subscriber {
    private Long id;
    private Set<User> userSubscriberId;
    private Set<User> subscriberTo;
    private LocalDateTime dateSubscribe;


//    public Subscriber(Set<User> userSubscriberId, Set<User> subscriberTo, LocalDateTime dateSubscribe) {
//        this.userSubscriberId = userSubscriberId;
//        this.subscriberTo = subscriberTo;
//        this.dateSubscribe = dateSubscribe;
//    }
}
