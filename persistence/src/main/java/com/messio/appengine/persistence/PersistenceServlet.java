package com.messio.appengine.persistence;

import com.messio.appengine.persistence.entity.Decision;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jpc on 28-12-16.
 */
public class PersistenceServlet extends HttpServlet {
    private EntityManagerFactory factory;

    @Override
    public void init() throws ServletException {
        this.factory = Persistence.createEntityManagerFactory("test");

        // get an EntityManager from the factory
        final EntityManager em = factory.createEntityManager();

        // Begin a transaction
        em.getTransaction().begin();

        em.persist(new Decision("a"));
        em.persist(new Decision("b"));
        em.persist(new Decision("c"));
        em.getTransaction().commit();

        // free the resources
        em.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        final EntityManager em = factory.createEntityManager();
        res.setContentType("text/html");
        res.getOutputStream().write("<html><head/><body>Persistence Servlet<ul>".getBytes());
        final List<Decision> decisions = em.createQuery("select d from Decision d", Decision.class).setMaxResults(100).getResultList();
        for (final Decision decision: decisions){
            res.getOutputStream().write(String.format("<li>%s</li>", decision.getReference()).getBytes());
        }
        em.close();
        res.getOutputStream().write("</ul></body></html>".getBytes());
    }
}
