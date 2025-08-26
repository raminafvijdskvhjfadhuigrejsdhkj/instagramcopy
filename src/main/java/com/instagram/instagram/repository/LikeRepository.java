package com.instagram.instagram.repository;
import com.instagram.instagram.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LikeRepository extends JpaRepository<Like, Long> {
}

