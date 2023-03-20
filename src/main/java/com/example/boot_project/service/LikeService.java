package com.example.boot_project.service;

import com.example.boot_project.dao.LikeDao;
import com.example.boot_project.dao.PublicationDao;
import com.example.boot_project.dao.UserDao;
import com.example.boot_project.dto.LikeDTO;
import com.example.boot_project.dto.PublicationDTO;
import com.example.boot_project.entity.Like;
import com.example.boot_project.entity.Publication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeService {
    private final PublicationDao publicationDao;
    private final UserDao userDao;
    private final LikeDao likeDao;

    public LikeService(PublicationDao publicationDao, UserDao userDao, LikeDao likeDao) {
        this.publicationDao = publicationDao;
        this.userDao = userDao;
        this.likeDao = likeDao;
    }

    public LikeDTO addLike(LikeDTO likeData) {
        var user = userDao.findByEmail("demo@demo").orElseThrow();
        var like = Like.builder()
                .id(likeData.getId())
                .userId(likeData.getUserId())
                .likeAim(likeData.getLikeAim())
                .dateOfLike(likeData.getDateOfLike())
                .build();
        likeDao.update(like);

        return LikeDTO.from(like);
    }

    public List<LikeDTO> addLikes(Long likeId) {
        var likesList = likeDao.findById(likeId);
        return likesList.stream().map(LikeDTO::from).collect(Collectors.toList());
    }

    public boolean deleteLike(Long likeId) {
        likeDao.deleteById(likeId);
        return true;
    }
    public boolean deleteAll() {
        likeDao.deleteAll();
        return true;
    }

}
