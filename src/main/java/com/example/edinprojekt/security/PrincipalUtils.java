package com.example.edinprojekt.security;

import com.example.edinprojekt.enitites.AppUser;
import com.example.edinprojekt.repositories.AppUserRepository;
import com.example.edinprojekt.views.ReviewView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

public class PrincipalUtils {

    @Autowired
    AppUserRepository appUserRepository;

    public AppUser getAppUserFromFromPrincipal(){
        return appUserRepository.findAppUserByUsername(getName()).orElseThrow();
    }

    public static String getName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public static boolean isAuthenticated(){
        return !SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()
                .equalsIgnoreCase("anonymousUser");
    }

    public static void logout(){
        UI.getCurrent().navigate(ReviewView.class);
        new SecurityContextLogoutHandler().logout(VaadinServletRequest.getCurrent().getHttpServletRequest(), null, null);
    }

}