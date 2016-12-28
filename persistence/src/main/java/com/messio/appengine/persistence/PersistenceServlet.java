package com.messio.appengine.persistence;

import com.messio.appengine.persistence.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

    @Override
    public void init() throws ServletException {
        // get an EntityManagerFactory using the Persistence class
        // It is not recommended to obtain a factory often, as construction of a
        // factory is a costly operation. Typically you will like to cache
        // a factory and then refer it for repeated use
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

        // get an EntityManager from the factory
        EntityManager em = factory.createEntityManager();

        // Begin a transaction
        em.getTransaction().begin();

        em.persist(new Employee("jpc"));
        em.persist(new Employee("annie"));
        em.persist(new Employee("frans"));

        // query for all employees who work in our research division
        // and put in over 40 hours a week average
/*
        Query query = em.createQuery("SELECT e " +
                "  FROM Employee e " +
                " WHERE e.division.name = 'Research' " +
                "   AND e.avgHours > 40");
        List results = query.getResultList();

        // give all those hard-working employees a raise
        for (Object res : results) {
            Employee emp = (Employee) res;
            emp.setSalary(emp.getSalary() * 1.1);
        }
*/


        // commit will detect all updated entities and save them in database
        em.getTransaction().commit();

        // free the resources
        em.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        res.getOutputStream().write("<html><head/><body>Persistence Servlet</body></html>".getBytes());
    }
}
