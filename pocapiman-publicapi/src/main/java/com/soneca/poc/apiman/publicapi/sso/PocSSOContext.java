package com.soneca.poc.apiman.publicapi.sso;

import com.soneca.poc.apiman.publicapi.entity.User;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

/**
 * Created by soneca on 04/08/16.
 */
public class PocSSOContext implements SecurityContext {


    private final User user;

    public PocSSOContext(User user) {
        this.user = user;
    }

    @Override
    public Principal getUserPrincipal() {
        return ()-> user.getName();
    }

    @Override
    public boolean isUserInRole(String role) {
        return role != null && role.equals(user.getRole());
    }

    @Override
    public boolean isSecure() {
        return true;
    }

    @Override
    public String getAuthenticationScheme() {
        return "Basic";
    }
}
