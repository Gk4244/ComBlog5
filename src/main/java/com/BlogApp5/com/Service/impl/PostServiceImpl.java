package com.BlogApp5.com.Service.impl;

import com.BlogApp5.com.Execption.ResourceNotFoundException;
import com.BlogApp5.com.Payload.CommentDto;
import com.BlogApp5.com.Payload.PostDto;
import com.BlogApp5.com.Repostories.PostRepoitory;
import com.BlogApp5.com.Service.PostService;
import com.BlogApp5.com.entites.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepoitory postRepoitory;

    public PostServiceImpl(PostRepoitory postRepoitory) {
        this.postRepoitory = postRepoitory;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost = postRepoitory.save(post);
        return mapToDto(savedPost);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> postList = postRepoitory.findAll();
        List<PostDto> collect = postList.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepoitory.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("post not found with id: " + id)
        );
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        Post post = postRepoitory.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("post not found with id: " + id)
        );
        post.setId(id);
        post.setTitle(postDto.getTitle());
        post.setDecription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepoitory.save(post);
        return mapToDto(updatedPost);
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepoitory.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("post not found with id: " + id)
        );
        postRepoitory.deleteById(id);
    }



    // 1. change Entity to Dto so use MaptoDto.------
    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDecription());
        dto.setContent(post.getContent());
        return dto;
    }
    //2. Change  Dto to Entity so use MaptoEntity.---
    Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDecription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
