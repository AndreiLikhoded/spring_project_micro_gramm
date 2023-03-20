package com.example.boot_project.service;


import com.example.boot_project.dao.CommentDao;
import com.example.boot_project.dao.PublicationDao;
import com.example.boot_project.dto.CommentDTO;
import com.example.boot_project.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final PublicationDao publicationDao;
    private final CommentDao commentDao;

    public CommentService(PublicationDao publicationDao, CommentDao commentDao) {
        this.publicationDao = publicationDao;
        this.commentDao = commentDao;
    }
    public CommentDTO addComment(CommentDTO commentDTO) {
        var comment = Comment.builder()
                .id(commentDTO.getId())
                .commentText(commentDTO.getCommentText())
                .dateComment(commentDTO.getDateComment())
                .userId(commentDTO.getUserId())
                .commentToPublication(commentDTO.getCommentToPublication())
                .build();
        commentDao.update(comment);

        return CommentDTO.from(comment);
    }

    public List<CommentDTO> addComments(Long commentId) {
        var commentsList = commentDao.findById(commentId);
        return commentsList.stream().map(CommentDTO::from).collect(Collectors.toList());
    }

    public boolean deleteComment() {
        commentDao.deleteAll();
        return true;
    }

}
