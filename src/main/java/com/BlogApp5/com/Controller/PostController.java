package com.BlogApp5.com.Controller;
import com.BlogApp5.com.Payload.PostDto;
import com.BlogApp5.com.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // http://localhost:8080/api/posts
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto postDto1 = postService.createPost(postDto);
        return new ResponseEntity<>(postDto1, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/posts
    @GetMapping
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }
    // http://localhost:8080/api/posts/{postId}
    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("postId") long id) {
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    // http://localhost:8080/api/posts/{postId}
    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable("postId") long id, @RequestBody PostDto postDto) {
        PostDto dto = postService.getPostById(id);
        PostDto postDto1 = postService.updatePost(id, postDto);
        return new ResponseEntity<>(postDto1, HttpStatus.OK);
    }

    // http://localhost:8080/api/posts/{postId}
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable("postId") long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post is deleted", HttpStatus.OK);
    }


}
