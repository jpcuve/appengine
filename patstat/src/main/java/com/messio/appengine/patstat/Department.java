package com.messio.appengine.patstat;

import javax.persistence.*;

/**
 * Created by jpc on 12/30/16.
 */
@Entity
@Table(name = "dept")
public class Department {
    @Id
    @Column(name = "deptno")
    private Integer id;
    @Basic
    @Column(name = "dname")
    private String name;
    @Basic
    @Column
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
