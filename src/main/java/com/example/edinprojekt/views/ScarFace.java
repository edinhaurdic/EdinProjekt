package com.example.edinprojekt.views;

import com.example.edinprojekt.services.ReviewService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route("/scarface")
public class ScarFace extends VerticalLayout {

    ReviewService reviewService;

    public ScarFace(ReviewService reviewService) {

        this.reviewService = reviewService;
        setAlignItems(Alignment.CENTER);

        H1 pageTitle = new H1("Review for Scarface");
        add(pageTitle);

        reviewService.findByTitle("Scarface").forEach(reviewPost -> {

            H2 reviewTitle = new H2(reviewPost.getTitle());
            Paragraph review = new Paragraph(reviewPost.getReview());

            add(reviewTitle,review);
        });



    }

}
