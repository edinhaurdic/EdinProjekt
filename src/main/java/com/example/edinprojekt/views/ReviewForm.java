package com.example.edinprojekt.views;

import com.example.edinprojekt.enitites.ReviewPost;
import com.example.edinprojekt.services.ReviewService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;

public class ReviewForm extends FormLayout{

    TextField title = new TextField("Title of Movie");
    TextArea review = new TextArea("Review of Movie");
    Button saveButton = new Button("Save review");
    ReviewService reviewService;
    ManageReviewView manageReviewView;


    Binder<ReviewPost> binder= new BeanValidationBinder<>(ReviewPost.class);

    public ReviewForm (ReviewService reviewService, ManageReviewView manageReviewView){
        this.reviewService = reviewService;
        this.manageReviewView = manageReviewView;
        setVisible(true);
        binder.bindInstanceFields(this);

        saveButton.addClickListener(evt-> onSave());

        add(title,review,saveButton);

    }

    private void onSave() {
        ReviewPost reviewPost=binder.validate().getBinder().getBean();
        if(reviewPost.getId()!= 0){
            reviewService.updateById(reviewPost.getId(), reviewPost);
        }else{
            reviewService.createReview(reviewPost);
        }
        setReviewPost(null);


    }

    public void setReviewPost(ReviewPost reviewPost){
        if(reviewPost != null){
            binder.setBean(reviewPost);
        }else {
            setVisible(false);
        }
    }
}
