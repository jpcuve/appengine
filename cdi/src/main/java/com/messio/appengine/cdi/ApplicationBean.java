package com.messio.appengine.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Created by jpc on 30-12-16.
 */
@Named
@ApplicationScoped
public class ApplicationBean {
    @PostConstruct
    public void init(){
        System.out.println("application bean init");
    }

    @PreDestroy
    public void done(){
        System.out.println("application bean done");
    }

}
