package com.messio.appengine.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jpc on 31-12-16.
 */
@ApplicationScoped
public class CdiServlet extends HttpServlet {
    @Inject
    private ApplicationBean applicationBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("application bean: " + applicationBean);
        res.setContentType("text/html");
        res.getOutputStream().write("<html><head/><body>Hello World</body></html>".getBytes());
    }
}
