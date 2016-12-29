package com.messio.appengine.facelets;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpc on 12/28/16.
 */
@ManagedBean
@ViewScoped
public class Bean implements Serializable {
    private List<String> texts = new ArrayList<>();
    private String text;

    public String getTest(){
        return "this string is coming from a jsf bean";
    }

    public String addText(){
        if (text != null && text.trim().length() > 0){
            texts.add(text.trim());
            text = null;
        }
        return null;
    }

    public List<String> getTexts() {
        return texts;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
