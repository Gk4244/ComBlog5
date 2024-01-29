package com.BlogApp5.com.Service.impl;

import com.BlogApp5.com.Repostories.CommentRepository;
import com.BlogApp5.com.entites.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment createComment(Comment comment) {

        // Add any additional logic here if needed
        return commentRepository.save(comment);
    }
}

