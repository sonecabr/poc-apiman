package com.soneca.poc.apiman.publicapi.core;


import org.jboss.resteasy.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

/**
 * Created by soneca on 20/07/16.
 */
@Path("/")
public class Bootstrap extends Application {

    private static final Logger LOG = Logger.getLogger(Application.class);

    public Bootstrap() {
        super();
        LOG.warn("Start Poc application...");
    }
}
