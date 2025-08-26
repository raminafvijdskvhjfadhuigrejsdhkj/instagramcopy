package com.instagram.instagram.repository;

import com.instagram.instagram.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}

