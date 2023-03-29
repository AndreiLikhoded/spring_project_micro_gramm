package com.example.boot_project.dto;

import com.example.boot_project.dao.SubscriberDao;
import com.example.boot_project.entity.Subscriber;
import com.example.boot_project.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)

public class SubscribeDTO {
    private final SubscriberDao subscriberDao;

    public static SubscribeDTO from(Subscriber subscriber) {
        return builder()
                .id(subscriber.getId())
                .userSubscriberId(subscriber.getUserSubscriberId())
                .subscriberTo(subscriber.getSubscriberTo())
                .dateSubscribe(subscriber.getDateSubscribe())
                .build();
    }
    private Long id;
    private User userSubscriberId;
    private User subscriberTo;
    private LocalDateTime dateSubscribe;

}
