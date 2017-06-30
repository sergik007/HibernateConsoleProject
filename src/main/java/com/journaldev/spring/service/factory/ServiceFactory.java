package com.journaldev.spring.service.factory;

import com.journaldev.spring.dao.HibernateUtil;
import com.journaldev.spring.service.PersonService;
import com.journaldev.spring.service.exception.ServiceFactoryException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Created by sergey on 30.6.17.
 */
public class ServiceFactory {
    private PersonService personService;

    public ServiceFactory(PersonService personService) {
        this.personService = personService;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public void openSession() throws ServiceFactoryException{
        try {
            HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
            throw new ServiceFactoryException(e);
        }
    }
    public void closeSession() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
