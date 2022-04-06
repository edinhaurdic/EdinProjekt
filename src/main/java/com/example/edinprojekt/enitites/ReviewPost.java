package com.example.edinprojekt.enitites;

import javax.persistence.*;

@Entity
public class ReviewPost {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private String review;

    public ReviewPost( String title, String review) {

        this.title = title;
        this.review = review;

    }

    public ReviewPost() {

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReview() {
        return review;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
