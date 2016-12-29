package com.messio.appengine.rest;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jpc on 12/29/16.
 */
@Path("/library")
@Produces({"application/json"})
public class Library {
    private Map<String, String> books = new HashMap<>();

    public Library() {
        books.put("1", "Brave new world");
        books.put("2", "The animal farm");
        books.put("3", "La voyageur imprudent");
    }

    @GET
    @Path("/books")
    public ArrayList<String> getBooks() {
        return new ArrayList<>(books.values());
    }

    @GET
    @Path("/book/{isbn}")
    public String getBook(@PathParam("isbn") String id) {
        return books.get(id);
    }

    @PUT
    @Path("/book/{isbn}")
    public void addBook(@PathParam("isbn") String id, @QueryParam("name") String name) {
        books.put(id, name);
    }

    @DELETE
    @Path("/book/{id}")
    public void removeBook(@PathParam("id") String id) {
        books.remove(id);
    }
}
