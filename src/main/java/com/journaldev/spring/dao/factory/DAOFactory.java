package com.journaldev.spring.dao.factory;

import com.journaldev.spring.dao.PersonDAO;
import org.hibernate.SessionFactory;

/**
 * Created by sergey on 30.6.17.
 */
public class DAOFactory {

    private PersonDAO personDAO;

    public DAOFactory(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

}
