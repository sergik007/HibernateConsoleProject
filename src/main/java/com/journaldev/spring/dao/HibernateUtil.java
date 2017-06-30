package com.journaldev.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Created by sergey on 21.6.17.
 */
public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;
    private static ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
    }
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
    public static void shotdown() {
        SESSION_FACTORY.close();
    }
}
