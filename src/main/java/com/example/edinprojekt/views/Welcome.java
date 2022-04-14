
package com.example.edinprojekt.views;
import com.example.edinprojekt.repositories.ReviewRepository;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;


@Route(value="", layout = AppView.class)
public class Welcome extends VerticalLayout {


    private ReviewRepository reviewRepository;
    TextField text=new TextField();

    public Welcome(ReviewRepository reviewRepository) {
        setAlignItems(Alignment.CENTER);

        RouterLink film1= new RouterLink("Scarface", Scarface.class);
        RouterLink film2= new RouterLink("Babblarna", Babblarna.class);
        //film1.setQueryParameters(new QueryParameters(Map.of("FilmID", List.of("1"))));
     //   film2.setQueryParameters(new QueryParameters(Map.of("FilmID", List.of("babblarna"))));
        this.reviewRepository = reviewRepository;

        add(new H1("Here is a list of our movies to review, choose one and leave your review"), film1, film2);

    }


}

