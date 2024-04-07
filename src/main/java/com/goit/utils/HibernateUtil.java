package com.goit.utils;

import com.goit.entity.Client;
import com.goit.entity.Planet;
import com.goit.entity.Ticket;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE = new HibernateUtil();
    private SessionFactory sessionFactory;

    private HibernateUtil() {
        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static HibernateUtil getInstance(){
        return INSTANCE;
    }
    public void closeSessionFactory(){
        this.sessionFactory.close();
    }
}
