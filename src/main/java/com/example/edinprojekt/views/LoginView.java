
package com.example.edinprojekt.views;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route("/login")
public class LoginView extends Div implements BeforeEnterObserver {

    LoginOverlay loginOverlay = new LoginOverlay();

    public LoginView(){

        loginOverlay.setTitle("FilmReview");
        loginOverlay.setDescription("Webbens bästa Review sida för filmer!");
        loginOverlay.setOpened(true);
        loginOverlay.setAction("login");

        add(loginOverlay);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent
                .getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            loginOverlay.setError(true);
        }
    }
}
