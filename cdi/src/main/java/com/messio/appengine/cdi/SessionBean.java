package com.messio.appengine.cdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by jpc on 30-12-16.
 */
@Named
@SessionScoped
public class SessionBean implements Serializable {
    @Inject
    private ApplicationBean applicationBean;

    @PostConstruct
    public void init(){
        System.out.println("session bean init");
    }

    @PreDestroy
    public void done(){
        System.out.println("session bean done");
    }

    public ApplicationBean getApplicationBean() {
        return applicationBean;
    }

    public void setApplicationBean(ApplicationBean applicationBean) {
        this.applicationBean = applicationBean;
    }
}
