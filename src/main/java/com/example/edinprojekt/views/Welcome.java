
package com.example.edinprojekt.views;
import com.example.edinprojekt.repositories.ReviewRepository;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


@Route("/welcome")
public class Welcome extends VerticalLayout {


    private ReviewRepository reviewRepository;
    TextField text=new TextField();

    public Welcome(ReviewRepository reviewRepository) {

        RouterLink film1= new RouterLink("SCARFACE", ScarFace.class);
        RouterLink film2= new RouterLink("Babblarna", Babblarna.class);
        film1.setQueryParameters(new QueryParameters(Map.of("FilmID", List.of("1"))));
        film2.setQueryParameters(new QueryParameters(Map.of("FilmID", List.of("2"))));
        this.reviewRepository = reviewRepository;

        add(new H1("Welcome to FilmReview"), film1, film2);

    }


}

