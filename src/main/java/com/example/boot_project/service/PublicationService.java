package com.example.boot_project.service;

import com.example.boot_project.dao.PublicationDao;
import com.example.boot_project.dao.UserDao;
import com.example.boot_project.dto.PublicationDTO;
import com.example.boot_project.entity.Publication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationService {
    private final PublicationDao publicationDao;
    private final UserDao userDao;

    public PublicationService(PublicationDao publicationDao, UserDao userDao) {
        this.publicationDao = publicationDao;
        this.userDao = userDao;
    }
    public PublicationDTO addPublication(PublicationDTO publicationData) {
        var user = userDao.findByEmail("demo@demo").orElseThrow();
        var publication = Publication.builder()
                .id(publicationData.getId())
                .userId(publicationData.getUserId())
                .image(publicationData.getImage())
                .description(publicationData.getDescription())
                .dateOfPublication(publicationData.getDateOfPublication())
                .build();
        publicationDao.update(publication);

        return PublicationDTO.from(publication);
    }

    public List<PublicationDTO> findPublications(Long publicationId) {
        var publicationList = publicationDao.findById(publicationId);
        return publicationList.stream().map(PublicationDTO::from).collect(Collectors.toList());
    }

    public boolean deletePublication(Long publicationId) {
        publicationDao.deleteById(publicationId);
        return true;
    }
    public boolean deleteAll() {
        publicationDao.deleteAll();
        return true;
    }
}
