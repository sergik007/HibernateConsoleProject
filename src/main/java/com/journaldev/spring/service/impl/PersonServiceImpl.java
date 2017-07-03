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

import com.journaldev.spring.model.Person;

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
	public void addPerson(Person p) throws ServiceException{
		logger.debug("Service.addPerson(Person p)");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			this.daoFactory.getPersonDAO().addPerson(p);
			tx.commit();
			logger.info("Person saved successfully, Person Details="+p);
		} catch (DAOException e) {
			logger.error("ошибка addPerson(Person p)");
			if (tx != null) {
				tx.rollback();
			}
			throw new ServiceException(e);
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void updatePerson(Person p) throws ServiceException{
		logger.debug("updatePerson(Person p)");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			this.daoFactory.getPersonDAO().updatePerson(p);
			tx.commit();
			logger.info("update person successfully");
		} catch (DAOException e) {
			logger.error("ошибка PersonService.updatePerson(Person p)");
			if (tx != null) {
				tx.rollback();
			}
			throw new ServiceException(e);
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public List<Person> listPersons() throws ServiceException{
		logger.debug("listPersons()");
		Session session = null;
		List<Person> people = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			people= this.daoFactory.getPersonDAO().listPersons();
			tx.commit();
		} catch (DAOException e) {
			logger.error("ошибка PersonService.updatePerson(Person p)");
			if (tx != null) {
				tx.rollback();
			}
			throw new ServiceException(e);
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return people;
	}

	@Override
	public Person getPersonById(int id) throws ServiceException{
		logger.debug("getPersonById(int id)");
		Session session = null;
		Transaction tx = null;
		Person person= null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			person =this.daoFactory.getPersonDAO().getPersonById(id);
			tx.commit();
			logger.info("getPersonById successfully");
		} catch (DAOException e) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("ошибка PersonService.updatePerson(Person p)");
			throw new ServiceException(e);
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return person;
	}

	@Override
	public void removePerson(int id) throws ServiceException {
		logger.debug("removePerson(int id)");
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			this.daoFactory.getPersonDAO().removePerson(id);
			tx.commit();
		} catch (DAOException e) {
			logger.error("ошибка PersonService.updatePerson(Person p)");
			if (tx != null) {
				tx.rollback();
			}
			throw new ServiceException(e);
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
}
