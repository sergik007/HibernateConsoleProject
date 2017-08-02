package epam.booking_apartment.service.impl;

import epam.booking_apartment.dao.ApartmentDAO;
import epam.booking_apartment.HibernateUtil;
import epam.booking_apartment.model.Apartment;
import epam.booking_apartment.service.ApartmentService;
import epam.booking_apartment.service.exception.ServiceException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("apartmentService")
public class ApartmentServiceImpl implements ApartmentService {

	@Autowired
	private ApartmentDAO apartmentDAO;


	@Override
	public void addApartment(Apartment p) throws ServiceException{
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			apartmentDAO.addApartment(p);
			tx.commit();
		} catch (DAOException e) {
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
	public void updateApartment(Apartment p) throws ServiceException{
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			apartmentDAO.updateApartment(p);
			tx.commit();
		} catch (DAOException e) {
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
	public List<Apartment> getAllApartments() throws ServiceException{
		Session session = null;
		List<Apartment> apartmentList = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			apartmentDAO.getAllApartments();
			tx.commit();
		} catch (DAOException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new ServiceException(e);
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return apartmentList;
	}

	@Override
	public Apartment getApartmentById(Long id) throws ServiceException{
		Session session = null;
		Transaction tx = null;
		Apartment apartment = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			apartmentDAO.getApartmentById(id);
			tx.commit();
		} catch (DAOException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new ServiceException(e);
		}finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return apartment;
	}

	@Override
	public void removeApartment(Long id) throws ServiceException {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			apartmentDAO.removeApartment(id);
			tx.commit();
		} catch (DAOException e) {
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
