package com.messio.appengine.facelets;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by jpc on 12/28/16.
 */
@ManagedBean
@RequestScoped
public class Bean {
    public String getTest(){
        return "this string is coming from a jsf bean";
    }
}
