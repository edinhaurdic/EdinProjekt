package com.example.edinprojekt.views;

import com.example.edinprojekt.services.ReviewService;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/reviewView", layout = AppView.class)
public class ReviewView extends VerticalLayout {

    ReviewService reviewService;

    public ReviewView(ReviewService reviewService) {
        this.reviewService = reviewService;
        setAlignItems(Alignment.CENTER);

        reviewService.findAll().forEach(reviewPost->{
            H2 reviewTitle = new H2(reviewPost.getTitle());
            Paragraph review=new Paragraph(reviewPost.getReview());

            add(reviewTitle,review,new Hr());
        });


    }
}
