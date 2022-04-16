package com.example.edinprojekt.views;
import com.example.edinprojekt.services.ReviewService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import javax.annotation.security.PermitAll;

@Route(value="/scarface", layout=AppView.class)
@PermitAll
public class Scarface extends VerticalLayout {

    ReviewService reviewService;

    public Scarface(ReviewService reviewService) {

        this.reviewService = reviewService;
        RouterLink reviewViewLink = new RouterLink("View reviews", ReviewView.class);
        renderReviewPost();

        RouterLink manageReviewLink = new RouterLink("Manage reviews", ManageReviewViewScarface.class);


    }

    private void renderReviewPost() {
        reviewService.findByTitle("Scarface").forEach(reviewPost -> {
            VerticalLayout reviewPostLayout = new VerticalLayout();
            H2 reviewTitle = new H2(reviewPost.getTitle());
            Paragraph review = new Paragraph(reviewPost.getReview());
            Button button = new Button("Delete", ev -> {
                reviewService.deleteByID(reviewPost.getId());
                Notification.show("Deleted"+ reviewPost.getId());
                updateReviewPosts();
            });

            reviewPostLayout.add(reviewTitle,review, button, new Hr());
            reviewPostLayout.setId(String.valueOf(reviewPost.getId()));
            reviewPostLayout.addClassName("ReviewPostLayout");

            add(reviewPostLayout);
        });

    }

    private void updateReviewPosts() {
        this.getChildren()
                .filter(component -> component.getElement().getClassList().contains("ReviewPostLayout"))
                        .forEach(this::remove);

        renderReviewPost();

    }

}
