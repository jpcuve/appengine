package com.messio.appengine.cdi;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by jpc on 1/2/17.
 */
@Path("/product")
@RequestScoped
public class ProductResource {
    @GET
    @Path("/single")
    @Produces("application/xml")
    public Product getProduct() {
        return new Product(1, "Mattress", new BigDecimal("500.23"));
    }

    @GET
    @Path("/catalog")
    @Produces("application/xml")
    public Catalog getCatalog(){
        return new Catalog(
                Arrays.asList(
                        new Product(1, "current1", new BigDecimal("10.4")),
                        new Product(2, "current2", new BigDecimal("15.4"))
                ),
                Arrays.asList(
                        new Product(3, "obsolete3", new BigDecimal("17.8")),
                        new Product(4, "obsolete4", new BigDecimal("21.9"))
                )
        );
    }
}
