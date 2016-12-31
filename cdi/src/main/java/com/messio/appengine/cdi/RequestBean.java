package com.messio.appengine.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by jpc on 30-12-16.
 */
@Named
@RequestScoped
public class RequestBean {
    @Inject
    private SessionBean sessionBean;

    @PostConstruct
    public void init(){
        System.out.println("request bean init");
    }

    @PreDestroy
    public void done(){
        System.out.println("request bean done");
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
