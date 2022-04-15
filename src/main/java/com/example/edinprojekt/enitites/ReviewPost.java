package com.example.edinprojekt.enitites;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class ReviewPost {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = false)
    @NotBlank
    private String title;

    @Column(nullable = false)
    @NotBlank
    private String review;

    @ManyToOne
    @JoinColumn(name="appuser_id")
    private AppUser appUser;

    public ReviewPost( String title, String review, AppUser appUser) {
        this.title = title;
        this.review = review;
        this.appUser = appUser;
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

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public void setId(int id) {
        this.id = id;
    }
}
