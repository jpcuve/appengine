package com.messio.appengine.patstat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by jpc on 12/30/16.
 */
@Path("/patstat")
@Produces({"application/json"})
public class PatstatResource {
    @GET
    @Path("/test")
    public String test() {
        return "test";
    }
}
