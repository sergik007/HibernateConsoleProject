package epam.booking_apartment.dao.impl;

import epam.booking_apartment.HibernateUtil;
import epam.booking_apartment.dao.AbstractDao;
import epam.booking_apartment.dao.ApartmentDAO;
import epam.booking_apartment.model.Apartment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("apartmentDao")
public class ApartmentDAOImpl extends AbstractDao<Long, Apartment> implements ApartmentDAO {

    private static final Logger logger = LoggerFactory.getLogger(ApartmentDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addApartment(Apartment p) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(p);
    }

    @Override
    public void updateApartment(Apartment p) {
        Session session = sessionFactory.getCurrentSession();
        session.update(p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Apartment> getAllApartments() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //List<Apartment> personsList = session.createCriteria(Apartment.class).list();
        List<Apartment> personsList = session.createQuery("from Apartment").list();
        return personsList;
    }

    @Override
    public Apartment getApartmentById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Apartment p = (Apartment) session.load(Apartment.class, new Long(id));
        logger.info("Apartment loaded successfully, Apartment details=" + p);
        return p;
    }

    @Override
    public void removeApartment(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Apartment p = (Apartment) session.load(Apartment.class, new Long(id));
        if (p != null) {
            session.delete(p);
        }
        logger.info("Apartment deleted successfully, person details=" + p);
    }
}
