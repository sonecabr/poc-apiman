package com.soneca.poc.apiman.publicapi.sso;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by soneca on 04/08/16.
 */

/*@Provider
@Priority(Priorities.AUTHENTICATION)*/
public class BasicAuthFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String authentication = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
    }
}
