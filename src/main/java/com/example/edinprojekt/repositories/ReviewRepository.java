package com.example.edinprojekt.repositories;


import com.example.edinprojekt.enitites.ReviewPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewPost, Integer> {
}
