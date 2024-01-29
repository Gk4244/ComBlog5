package com.BlogApp5.com.Repostories;

import com.BlogApp5.com.entites.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepoitory extends JpaRepository<Post, Long> {
}
