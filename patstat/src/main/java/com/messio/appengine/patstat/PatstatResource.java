package com.messio.appengine.patstat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpc on 12/30/16.
 */
@Path("/patstat")
@Produces({"application/json"})
public class PatstatResource {
    private EntityManagerFactory factory;



    public PatstatResource() {
        System.out.println("creating new patstat resource");
        this.factory = Persistence.createEntityManagerFactory("test");
    }

    @GET
    @Path("/test")
    public String test() {
        return "test";
    }

    @GET
    @Path("/departments")
    public ArrayList<Department> findDepartments(){
        final EntityManager em = factory.createEntityManager();
        final List<Department> departments = em.createQuery("select d from Department d", Department.class).setMaxResults(100).getResultList();
        em.close();
        return new ArrayList<>(departments);
    }
}
