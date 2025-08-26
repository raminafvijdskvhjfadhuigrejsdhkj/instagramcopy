package com.instagram.instagram.service;

import com.instagram.instagram.model.Follow;
import com.instagram.instagram.model.User;
import com.instagram.instagram.repository.FollowRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
    private final FollowRepository followRepository;

    public FollowService(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    public Follow follow(User follower, User following) {
        Follow f = new Follow();
        f.setFollower(follower);
        f.setFollowing(following);
        return followRepository.save(f);
    }
}
