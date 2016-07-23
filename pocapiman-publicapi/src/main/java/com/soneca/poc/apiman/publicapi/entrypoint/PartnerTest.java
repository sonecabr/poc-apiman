package com.soneca.poc.apiman.publicapi.entrypoint;

import com.soneca.poc.apiman.publicapi.entity.Item;
import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.resteasy.logging.Logger;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.security.Principal;
import java.util.Random;
import java.util.UUID;


/**
 * Created by soneca on 20/07/16.
 */
@Path("/partner")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
@SecurityDomain("keycloak")
public class PartnerTest {

    private static final Logger LOG = Logger.getLogger(PartnerTest.class);

    @Context
    private Request request;

    @Context
    private Response response;

    @Context
    private UriInfo uriInfo;

    @Inject
    private Principal principal;

    @GET
    @RolesAllowed({"partner"})
    @Path("/protected")
    public Response protectedGet() {
        LOG.info("Processing request...");
        return Response.ok(
                new Item()
                        .id(new Random().nextInt(100))
                        .name(UUID.randomUUID().toString())
        ).build();
    }

    @GET
    @Path("/public")
    @PermitAll
    public Response publicGet() {
        LOG.info("Processing request...");
        return Response.ok(
                new Item()
                        .id(new Random().nextInt(100))
                        .name(UUID.randomUUID().toString())
        ).build();
    }
}
