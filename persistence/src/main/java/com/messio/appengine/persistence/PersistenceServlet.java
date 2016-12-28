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
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        res.getOutputStream().write("<html><head/><body>Persistence Servlet<ul>".getBytes());
        // get an EntityManagerFactory using the Persistence class
        // It is not recommended to obtain a factory often, as construction of a
        // factory is a costly operation. Typically you will like to cache
        // a factory and then refer it for repeated use
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");

        // get an EntityManager from the factory
        final EntityManager em = factory.createEntityManager();

        // Begin a transaction
        em.getTransaction().begin();

        final List<Employee> employees = em.createQuery("select e from Employee e", Employee.class).getResultList();
        for (final Employee employee: employees){
            res.getOutputStream().write(String.format("<li>%s</li>", employee.getUser()).getBytes());

        }

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
        res.getOutputStream().write("</ul></body></html>".getBytes());
    }
}
