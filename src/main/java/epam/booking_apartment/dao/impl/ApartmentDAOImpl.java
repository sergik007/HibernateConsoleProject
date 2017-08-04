package epam.booking_apartment.dao.impl;

import epam.booking_apartment.HibernateUtil;
import epam.booking_apartment.dao.AbstractDao;
import epam.booking_apartment.dao.ApartmentDAO;
import epam.booking_apartment.model.Apartment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("apartmentDao")
public class ApartmentDAOImpl extends AbstractDao<Long, Apartment> implements ApartmentDAO {



    @Override
    public void addApartment(Apartment p) throws HibernateException {
        persist(p);
    }

    @Override
    public void updateApartment(Apartment p) throws HibernateException {
        update(p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Apartment> getAllApartments() throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        List<Apartment> personsList = session.createCriteria(Apartment.class).list();
        return personsList;
    }

    @Override
    public Apartment getApartmentById(Long id) throws HibernateException {
        return getByKey(id);
    }

    @Override
    public void removeApartment(Apartment apartment) throws HibernateException {
        delete(apartment);
    }
}
