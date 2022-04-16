package com.example.edinprojekt.views;

import com.example.edinprojekt.services.ReviewService;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route(value = "/reviewView", layout = AppView.class)
@AnonymousAllowed
public class ReviewView extends VerticalLayout {

    ReviewService reviewService;

    public ReviewView(ReviewService reviewService) {
        this.reviewService = reviewService;
        setAlignItems(Alignment.CENTER);

        reviewService.findAll().forEach(reviewPost->{
            H2 reviewTitle = new H2(reviewPost.getTitle());
            Paragraph review=new Paragraph(reviewPost.getReview());
            Paragraph writer = new Paragraph("Written by: ");
            Span author = new Span(reviewPost.getAppUser().getUsername());
            author.getStyle().set("font-weight", "bold");
            author.getStyle().set("color", "blue");
            writer.add(author);

            add(reviewTitle,review,writer,new Hr());
        });


    }
}
