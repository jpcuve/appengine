package com.messio.appengine.persistence.entity;

import javax.persistence.*;

/**
 * Created by jpc on 12/29/16.
 */
@Entity
@Table(name = "decision")
public class Decision {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "reference")
    private String reference;

    public Decision() {
    }

    public Decision(String reference) {
        this.reference = reference;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
