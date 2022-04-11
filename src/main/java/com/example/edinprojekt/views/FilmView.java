package com.example.edinprojekt.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route("/filmView")
public class FilmView extends VerticalLayout implements BeforeEnterObserver {

    String FilmId;

    public FilmView() {


        add(new H1("Filmview"));



    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {

        FilmId = beforeEnterEvent.getLocation().getQueryParameters().getParameters().get("FilmID").get(0);
        add(new Paragraph("FilmId"+FilmId));
    }
}
