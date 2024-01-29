package com.BlogApp5.com.Service;

import com.BlogApp5.com.Payload.CommentDto;
import com.BlogApp5.com.Payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatePost(long id, PostDto postDto);

    void deletePostById(long id);


}
