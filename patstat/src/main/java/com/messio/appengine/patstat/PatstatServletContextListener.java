package com.messio.appengine.patstat;

import org.flywaydb.core.Flyway;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by jpc on 12/30/16.
 */
public class PatstatServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/orcl", "scott", "tiger");
        flyway.migrate();

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
