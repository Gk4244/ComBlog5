package com.BlogApp5.com.Repostories;

import com.BlogApp5.com.entites.Comment;
import com.BlogApp5.com.entites.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment, Long> {
}
