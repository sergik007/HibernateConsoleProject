package com.journaldev.spring.dao.impl;

import java.util.List;

import com.journaldev.spring.dao.HibernateUtil;
import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.dao.exception.DAOException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.journaldev.spring.model.Person;

public class PersonDAOImpl implements PersonDAO {

    private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

    @Override
    public void addPerson(Person p) throws DAOException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(p);
    }

    @Override
    public void updatePerson(Person p) throws DAOException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.update(p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //List<Person> personsList = session.createCriteria(Person.class).list();
        List<Person> personsList = session.createQuery("from Person ").list();
        for (Person p : personsList) {
            logger.info("Person List::" + p);
        }
        return personsList;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        logger.info("Person loaded successfully, Person details=" + p);
        return p;
    }

    @Override
    public void removePerson(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        if (p != null) {
            session.delete(p);
        }
        logger.info("Person deleted successfully, person details=" + p);
    }
}
