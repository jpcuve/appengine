package com.messio.appengine.persistence.entity;

import javax.persistence.*;

/**
 * Created by jpc on 28-12-16.
 */
@Entity
@Table(name = "binder")
public class Employee {
    @Id
    @Column(name = "Host")
    private String host;
    @Column(name = "User")
    private String user;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
