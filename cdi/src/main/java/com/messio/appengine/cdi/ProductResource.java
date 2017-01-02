package com.messio.appengine.cdi;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.math.BigDecimal;

/**
 * Created by jpc on 1/2/17.
 */
@Path("/product")
@RequestScoped
public class ProductResource {
    @GET
    @Path("/get")
    @Produces("application/xml")
    public Product getProduct() {
        Product prod = new Product();
        prod.setId(1);
        prod.setName("Mattress");
        prod.setPrice(new BigDecimal("500.23"));
        return prod;
    }
}
