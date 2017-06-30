package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.exception.ServiceException;

public interface PersonService {

    void addPerson(Person p) throws ServiceException;

    void updatePerson(Person p) throws ServiceException;

    List<Person> listPersons() throws ServiceException;

    Person getPersonById(int id) throws ServiceException;

    void removePerson(int id) throws ServiceException;

}
