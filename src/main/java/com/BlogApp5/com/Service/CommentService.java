package com.BlogApp5.com.Service;


import com.BlogApp5.com.entites.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    Comment createComment(Comment comment);
}

