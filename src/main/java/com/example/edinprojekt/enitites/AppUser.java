package com.example.edinprojekt.enitites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy = "appUser")
    @JsonIgnore
    private Set<ReviewPost> reviewPost;

    public AppUser(String username) {
        this.username = username;
    }

    public AppUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ReviewPost> getReviewPost() {
        return reviewPost;
    }

    public void setReviewPost(Set<ReviewPost> reviewPost) {
        this.reviewPost = reviewPost;
    }
}
