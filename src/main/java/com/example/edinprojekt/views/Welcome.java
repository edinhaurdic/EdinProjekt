
package com.example.edinprojekt.views;
import com.example.edinprojekt.repositories.ReviewRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;


@Route(value="/", layout = AppView.class)
@AnonymousAllowed
public class Welcome extends VerticalLayout {


    private ReviewRepository reviewRepository;
    TextField text=new TextField();

    public Welcome(ReviewRepository reviewRepository) {
        setAlignItems(Alignment.CENTER);

        Button scarface = new Button("Scarface", e -> UI.getCurrent().navigate(Scarface.class));
        Button babblarna = new Button("Babblarna", e-> UI.getCurrent().navigate(Babblarna.class));
        H1 pageTitle = new H1("Here is a list of our movies to review.");
        //film1.setQueryParameters(new QueryParameters(Map.of("FilmID", List.of("1"))));
     //   film2.setQueryParameters(new QueryParameters(Map.of("FilmID", List.of("babblarna"))));
        this.reviewRepository = reviewRepository;

        add(pageTitle, scarface, babblarna);

    }


}

