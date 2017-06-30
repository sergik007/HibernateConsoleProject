package com.journaldev.spring.service.impl;

import java.util.List;

import com.journaldev.spring.dao.HibernateUtil;
import com.journaldev.spring.dao.exception.DAOException;
import com.journaldev.spring.dao.factory.DAOFactory;
import com.journaldev.spring.service.PersonService;
import com.journaldev.spring.service.exception.ServiceException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
	
	private DAOFactory daoFactory;

	public PersonServiceImpl(DAOFactory daoFactory) {
		logger.debug("PersonServiceImpl(DAOFactory daoFactory)");
		this.daoFactory = daoFactory;
	}

	public void setPersonDAO(DAOFactory daoFactory) {
		logger.debug("setPersonDAO(DAOFactory daoFactory)");
		this.daoFactory = daoFactory;
	}


	@Override
	@Transactional
	public void addPerson(Person p) throws ServiceException{
		logger.debug("Service.addPerson(Person p)");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			this.daoFactory.getPersonDAO().addPerson(p);
			tx.commit();
			logger.info("Person saved successfully, Person Details="+p);
		} catch (DAOException e) {
			tx.rollback();
			logger.error("ошибка addPerson(Person p)");
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional
	public void updatePerson(Person p) throws ServiceException{
		try {
			logger.debug("updatePerson(Person p)");
			this.daoFactory.getPersonDAO().updatePerson(p);
		} catch (DAOException e) {
			logger.error("ошибка PersonService.updatePerson(Person p)");
			throw new ServiceException(e);
		}

	}

	@Override
	@Transactional
	public List<Person> listPersons() throws ServiceException{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession()
		List<Person> people = null;
		Transaction tx = null;
		try {
			logger.debug("listPersons()");

			people= this.daoFactory.getPersonDAO().listPersons();
		} catch (DAOException e) {
			logger.error("ошибка PersonService.updatePerson(Person p)");
			throw new ServiceException(e);
		}
		return people;
	}

	@Override
	@Transactional
	public Person getPersonById(int id) throws ServiceException{
		Person person= null;
		try {
			logger.debug("getPersonById(int id)");
			person =this.daoFactory.getPersonDAO().getPersonById(id);
		} catch (DAOException e) {
			logger.error("ошибка PersonService.updatePerson(Person p)");
			throw new ServiceException(e);
		}
		return person;
	}

	@Override
	@Transactional
	public void removePerson(int id) throws ServiceException {
		Person person= null;
		try {
			logger.debug("removePerson(int id)");
			this.daoFactory.getPersonDAO().removePerson(id);
		} catch (DAOException e) {
			logger.error("ошибка PersonService.updatePerson(Person p)");
			throw new ServiceException(e);
		}
	}
}
