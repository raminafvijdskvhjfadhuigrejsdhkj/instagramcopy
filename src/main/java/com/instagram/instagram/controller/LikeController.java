package com.instagram.instagram.controller;

import com.instagram.instagram.model.Like;
import com.instagram.instagram.repository.LikeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeRepository likeRepository;

    public LikeController(LikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }

    @GetMapping
    public List<Like> getAllLikes(){
        return likeRepository.findAll();
    }

    @PostMapping
    public Like createLike(@RequestBody Like like){
        return likeRepository.save(like);
    }


    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Long id){
        likeRepository.deleteById(id);
    }



}
