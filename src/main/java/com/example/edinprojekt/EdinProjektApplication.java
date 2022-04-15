package com.example.edinprojekt;

import com.example.edinprojekt.enitites.AppUser;
import com.example.edinprojekt.enitites.ReviewPost;
import com.example.edinprojekt.repositories.AppUserRepository;
import com.example.edinprojekt.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EdinProjektApplication implements CommandLineRunner {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public static void main(String[] args) {
        SpringApplication.run(EdinProjektApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        AppUser Edin= new AppUser("Edin", "edin");
        AppUser Alice = new AppUser("Alice", "alice");
       // AppUser Gustav= new AppUser("Gustav");
        appUserRepository.saveAll(List.of(Edin, Alice));

        ReviewPost reviewPost = new ReviewPost("Scarface", "This movie is great", Edin);
        ReviewPost reviewPost2 = new ReviewPost("Scarface", "Too much drugs and violence", Alice);
        ReviewPost reviewPost3 = new ReviewPost("Babblarna", "This movie is a instant classic", Alice);
        ReviewPost reviewPost4 = new ReviewPost("Babblarna", "Great movie for babys", Edin);
        reviewRepository.saveAll(List.of(reviewPost, reviewPost2, reviewPost3, reviewPost4));
    }
}
