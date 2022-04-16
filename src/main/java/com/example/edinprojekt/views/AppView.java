package com.example.edinprojekt.views;

import com.example.edinprojekt.security.PrincipalUtils;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
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
        VerticalLayout buttonLayout = new VerticalLayout();
        H1 navbarTitle= new H1("Welcome to FilmReview");
        navbarTitle.getStyle().set("font-weight", "bolder");
        navbarTitle.getStyle().set("color", "red");
        navbarTitle.getStyle().set("font-size", "60px");
        //Button homeButton = new Button("Home");
        navbarLayout.add(new DrawerToggle(), navbarTitle);


        Button loginButton= new Button("Login", e-> UI.getCurrent().navigate(LoginView.class));
        Button logOutButton = new Button("Logout",e-> PrincipalUtils.logout());
        loginButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        logOutButton.addThemeVariants(ButtonVariant.LUMO_ERROR);


        navbarLayout.add(PrincipalUtils.isAuthenticated() ? logOutButton : loginButton);

        if(PrincipalUtils.isAuthenticated())
            Notification.show(PrincipalUtils.getName());


        navbarLayout.setWidthFull();
        navbarLayout.setMargin(true);
        navbarLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbarLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        addToNavbar(navbarLayout);


        RouterLink reviewViewLink = new RouterLink("View reviews", ReviewView.class);
        RouterLink manageReviewLink = new RouterLink("Manage reviews", ManageReviewViewScarface.class);
        RouterLink homeViewLink = new RouterLink("Home", Welcome.class);

        addToDrawer(new VerticalLayout(manageReviewLink, reviewViewLink, homeViewLink));

    }
}
