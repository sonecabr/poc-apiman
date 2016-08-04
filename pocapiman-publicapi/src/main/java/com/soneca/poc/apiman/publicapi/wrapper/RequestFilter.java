package com.soneca.poc.apiman.publicapi.wrapper;

import com.soneca.poc.apiman.publicapi.entity.User;
import com.soneca.poc.apiman.publicapi.sso.PocSSOContext;
import org.jboss.resteasy.logging.Logger;

import org.keycloak.admin.client.Keycloak;


import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;


import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;


/**
 * Created by soneca on 04/08/16.
 */
@Provider
@PreMatching
public class RequestFilter implements ContainerRequestFilter {


    private Logger LOG = Logger.getLogger(RequestFilter.class);


    @Inject
    private Principal principal;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

        if (LOG.isDebugEnabled()) {
            LOG.debug("FILTERING REQUEST for " + containerRequestContext.getUriInfo().getPath() + " [" +
                    containerRequestContext.getMethod() + "]");
        }

        if(containerRequestContext.getHeaders().get("_ut") != null &&
                containerRequestContext.getHeaders().get("_ut").stream().allMatch(item -> item.contains("xyz"))){
            containerRequestContext.setSecurityContext(new PocSSOContext(new User().id("1").name("Soneca").role("partner")));
        }

        /*Keycloak keycloak = loadPrincipal();*/
    }
/*

    private void getRoleInRequest(ContainerRequestContext context) {
        Principal principal = context.getSecurityContext().getUserPrincipal();

    }
*/


    private Keycloak loadPrincipal() {
        Keycloak keycloak =
                Keycloak.getInstance(
                        "http://192.168.5.237:8080/auth",
                        "partner-realm",
                        "partner-user",
                        "123",
                        "partner-client",
                        "36afa019-2fc5-4c61-be37-41017b20a85e");
        return keycloak;
    }

  /*  private void logPartner(CredentialRepresentation credentialRepresentation) {
        UserRepresentation user = new UserRepresentation();
        user.setUsername("sonecateste");
        user.setFirstName("sonequeira");
        user.setLastName("lavaioporco");
        user.setCredentials(Arrays.asList(credentialRepresentation));
        this.keycloak.realm("partner").users().create(user);
    }*/

}
