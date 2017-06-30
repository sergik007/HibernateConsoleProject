package com.journaldev.spring.dao;

import com.journaldev.spring.dao.exception.DAOException;
import com.journaldev.spring.dao.factory.DAOFactory;
import com.journaldev.spring.model.Person;

import java.util.List;


public interface PersonDAO {

    void addPerson(Person p) throws DAOException;

    void updatePerson(Person p) throws DAOException;

    List<Person> listPersons() throws DAOException;

    Person getPersonById(int id) throws DAOException;

    void removePerson(int id) throws DAOException;
}
