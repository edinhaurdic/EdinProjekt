/*
package com.example.edinprojekt.controllers;

import com.example.edinprojekt.enitites.ReviewPost;
import com.example.edinprojekt.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping
    public String getReviewPostList(@RequestParam(required = false)String username, Model model) {
        List<ReviewPost> reviewPostList = reviewService.findAll(username);
        model.addAttribute("reviewPostList", reviewPostList);
        return "welcome";

    }

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
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
*/
