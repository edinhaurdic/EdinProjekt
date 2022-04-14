package com.example.edinprojekt.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class AppView extends AppLayout {

    public AppView() {

        HorizontalLayout navbarLayout = new HorizontalLayout();
        H1 navbarTitle= new H1("Welcome to FilmReview");
        Button loginButton= new Button("Login", e-> Notification.show("Coming soon..."));
        loginButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        navbarLayout.add(new DrawerToggle(), navbarTitle, loginButton);

        navbarLayout.setWidthFull();
        navbarLayout.setMargin(true);
        navbarLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbarLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        addToNavbar(navbarLayout);

        RouterLink reviewViewLink = new RouterLink("View reviews", ReviewView.class);
        RouterLink manageReviewLink = new RouterLink("Manage reviews", ManageReviewView.class);

        addToDrawer(new VerticalLayout(manageReviewLink, reviewViewLink));

    }
}
