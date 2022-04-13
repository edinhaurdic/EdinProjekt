package com.example.edinprojekt.services;


import com.example.edinprojekt.enitites.ReviewPost;
import com.example.edinprojekt.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

   /* @Autowired
            ReviewRepository reviewRepository;*/


    ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }


    public List<ReviewPost> findAll(String username) {
        if(username == null){
            return reviewRepository.findAll();
        } else{
          return reviewRepository.findByAppUser_Username(username);
        }
    }

   public List<ReviewPost> findByTitle(String title) {
        if(title == null){
            return reviewRepository.findAll();
        }else {
            return reviewRepository.findByTitle(title);
        }

    }

    public ReviewPost findById(int id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    public void deleteByID(int id) {
        reviewRepository.deleteById(id);
    }

    public ReviewPost createReview(ReviewPost reviewPost) {
        return reviewRepository.save(reviewPost);
    }

    public ReviewPost updateById(int id, ReviewPost changedReviewPost) {

        ReviewPost reviewPost= reviewRepository.findById(id).orElseThrow();

      if(changedReviewPost.getTitle() !=null)
            reviewPost.setTitle(changedReviewPost.getTitle());
        if(changedReviewPost.getReview()!= null)
            reviewPost.setReview(changedReviewPost.getReview());

        return reviewRepository.save(reviewPost);
      //  BeanUtils.copyProperties(changedReviewPost, existingReviewPost, "id");
    }
}
