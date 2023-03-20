package com.example.boot_project.service;

import com.example.boot_project.dao.SubscriberDao;
import com.example.boot_project.dao.UserDao;
import com.example.boot_project.dto.PublicationDTO;
import com.example.boot_project.dto.SubscribeDTO;
import com.example.boot_project.entity.Publication;
import com.example.boot_project.entity.Subscriber;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriberService {
    private final SubscriberDao subscriberDao;
    private final UserDao userDao;

    public SubscriberService(SubscriberDao subscriberDao, UserDao userDao) {
        this.subscriberDao = subscriberDao;
        this.userDao = userDao;
    }

    public SubscribeDTO addSubscriber(SubscribeDTO subscribeData) {
        var user = userDao.findByEmail("demo@demo").orElseThrow();
        var subscriber = Subscriber.builder()
                .id(subscribeData.getId())
                .userSubscriberId(subscribeData.getUserSubscriberId())
                .subscriberTo(subscribeData.getSubscriberTo())
                .dateSubscribe(subscribeData.getDateSubscribe())
                .build();
        subscriberDao.update(subscriber);

        return SubscribeDTO.from(subscriber);
    }

    public List<SubscribeDTO> findSubscribers(Long subscriberId) {
        var subscriberList = subscriberDao.findById(subscriberId);
        return subscriberList.stream().map(SubscribeDTO::from).collect(Collectors.toList());
    }

}
