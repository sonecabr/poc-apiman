package com.soneca.poc.apiman.publicapi.entrypoint;

import com.soneca.poc.apiman.publicapi.entity.Item;
import org.jboss.resteasy.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.util.Random;
import java.util.UUID;

/**
 * Created by soneca on 20/07/16.
 */
@Path("/partner")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PartnerTest {

    private static final Logger LOG = Logger.getLogger(PartnerTest.class);

    @Context
    private Request request;

    @Context
    private Response response;

    @GET
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
    public Response publicGet() {
        LOG.info("Processing request...");
        return Response.ok(
                new Item()
                        .id(new Random().nextInt(100))
                        .name(UUID.randomUUID().toString())
        ).build();
    }
}
