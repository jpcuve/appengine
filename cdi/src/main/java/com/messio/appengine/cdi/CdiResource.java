package com.messio.appengine.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by jpc on 12/30/16.
 */
/*
@Path("/cdi")
@Produces({"application/json"})
@ApplicationScoped
*/
public class CdiResource {
    @Inject
    private RequestBean requestBean;

    @GET
    @Path("/test")
    public String test() {
        final ApplicationBean applicationBean = requestBean.getSessionBean().getApplicationBean();
        return "test";
    }

}
