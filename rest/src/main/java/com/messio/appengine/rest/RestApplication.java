package com.messio.appengine.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jpc on 12/29/16.
 */
@ApplicationPath("/")
public class RestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses(){
        return new HashSet<Class<?>>(Arrays.asList(Library.class));
    }
}
