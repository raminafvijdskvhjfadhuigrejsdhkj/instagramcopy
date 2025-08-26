package com.instagram.instagram.controller;
import com.instagram.instagram.model.Post;
import com.instagram.instagram.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/posts")

public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }


    @GetMapping
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postRepository.save(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }
}
