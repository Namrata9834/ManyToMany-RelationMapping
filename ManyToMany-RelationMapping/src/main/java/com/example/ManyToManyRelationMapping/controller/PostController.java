package com.example.ManyToManyRelationMapping.controller;

import com.example.ManyToManyRelationMapping.entity.Post;
import com.example.ManyToManyRelationMapping.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping
public class PostController {
    private  PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping

    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("Post not found"));
    }
}
