package com.example.boot_project.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
