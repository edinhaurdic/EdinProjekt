package com.example.edinprojekt.repositories;


import com.example.edinprojekt.enitites.ReviewPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewPost, Integer> {

    List<ReviewPost> findByAppUser_Username(String username);

    List<ReviewPost> findByTitle(String title);
}