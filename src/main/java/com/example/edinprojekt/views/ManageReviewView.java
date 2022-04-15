package com.example.edinprojekt.views;

import com.example.edinprojekt.enitites.ReviewPost;
import com.example.edinprojekt.services.ReviewService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


import javax.annotation.security.PermitAll;

@Route(value= "/managereviews", layout = AppView.class)
@PermitAll
public class ManageReviewView extends VerticalLayout {

    ReviewService reviewService;
    Grid<ReviewPost> grid= new Grid<>(ReviewPost.class, false);
    ReviewForm reviewForm;

    public ManageReviewView(ReviewService reviewService) {
        this.reviewService = reviewService;
        reviewForm = new ReviewForm(reviewService, this);
        setAlignItems(Alignment.CENTER);
        add(new H1("Manage reviews"));


        grid.setItems(reviewService.findAll());

        grid.addComponentColumn(reviewPost -> {

            Button deleteButton= new Button(new Icon(VaadinIcon.AIRPLANE), evt->{
                reviewService.deleteByID(reviewPost.getId());
                updateItems();
            });
            deleteButton.addThemeVariants(
                    ButtonVariant.LUMO_SUCCESS,
                    ButtonVariant.LUMO_ICON,
                    ButtonVariant.LUMO_ERROR
            );
            return deleteButton;
        });


        grid.addColumn(ReviewPost::getId).setHeader("Id").setSortable(true);
        grid.addColumn(ReviewPost::getTitle).setHeader("Title of Movie").setSortable(true);
        grid.addColumn(ReviewPost::getReview).setHeader("Review of Movie").setSortable(true);
        // grid.addColumn(reviewPost -> reviewPost.getAppUser().getUsername()).setHeader("Author").setSortable(true);
        grid.asSingleSelect().addValueChangeListener(evt->{
            reviewForm.setReviewPost(evt.getValue());
        });

        HorizontalLayout mainContent = new HorizontalLayout(grid, reviewForm);
        mainContent.setSizeFull();

        add(mainContent);

        Button newReviewButton = new Button("Add new review",evt->{
            Dialog dialog = new Dialog();
            ReviewForm form = new ReviewForm(reviewService, this);
            reviewForm.setReviewPost(new ReviewPost());
            dialog.add(reviewForm);
            dialog.open();
        });
        add(newReviewButton);
    }

    public void updateItems() {
        grid.setItems(reviewService.findAll());
    }
}
