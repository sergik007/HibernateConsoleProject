package com.journaldev.spring.dao.impl;

import java.util.List;

import com.journaldev.spring.dao.HibernateUtil;
import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.dao.exception.DAOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addPerson(Person p) throws DAOException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(p);

    }

    @Override
    public void updatePerson(Person p) throws DAOException {
        Session  session = this.sessionFactory.openSession();
        session.update(p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createCriteria(Person.class).list();
        //List<Person> personsList = session.createQuery("from Person").list();
        for (Person p : personsList) {
            logger.info("Person List::" + p);
        }
        return personsList;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        logger.info("Person loaded successfully, Person details=" + p);
        return p;
    }

    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Person deleted successfully, person details=" + p);
    }

}
