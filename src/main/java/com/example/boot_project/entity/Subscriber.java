package com.example.boot_project.entity;


import com.example.boot_project.util.Generator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subscriber {
    private Long id;
    private User userSubscriberId;
    private User subscriberTo;
    private LocalDateTime dateSubscribe;

}
