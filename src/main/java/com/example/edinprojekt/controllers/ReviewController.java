package com.example.edinprojekt.controllers;

import com.example.edinprojekt.enitites.ReviewPost;
import com.example.edinprojekt.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scarface")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping
    public List<ReviewPost> getReviewPostList(){
        return reviewService.findAll();
    }

   @GetMapping("/{id}")
    public ReviewPost getReviewPostById(@PathVariable("id") int id){
        return reviewService.findById(id);
   }

   @DeleteMapping("/{id}")
    public void deletePostByID(@PathVariable("id") int id){
        reviewService.deleteByID(id);
   }

   @PostMapping()
    public ReviewPost createNewReviewPost(@RequestBody ReviewPost reviewPost){
        return reviewService.createReview(reviewPost);
   }

   @PutMapping("/{id}")
    public ReviewPost updateReviewPostByID(
            @PathVariable("id") int id,
            @RequestBody ReviewPost changedReviewPost){

        return reviewService.updateById(id, changedReviewPost);
   }

}
