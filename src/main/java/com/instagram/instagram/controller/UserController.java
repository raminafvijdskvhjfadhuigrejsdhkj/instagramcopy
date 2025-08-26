package com.instagram.instagram.controller;

import com.instagram.instagram.model.Follow;
import com.instagram.instagram.model.User;
import com.instagram.instagram.repository.UserRepository;
import com.instagram.instagram.service.FollowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final FollowService followService;

    public UserController(UserRepository userRepository, FollowService followService){
        this.userRepository = userRepository;
        this.followService = followService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // 🔹 Подписка
    @PostMapping("/{id}/follow")
    public Follow follow(@PathVariable Long id, @RequestParam Long currentUserId) {
        User currentUser = userRepository.findById(currentUserId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        User following = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return followService.follow(currentUser, following);
    }
}
