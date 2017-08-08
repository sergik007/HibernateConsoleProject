package epam.booking_apartment.service.impl;

import epam.booking_apartment.HibernateUtil;
import epam.booking_apartment.dao.ApartmentDAO;
import epam.booking_apartment.dao.impl.ApartmentDAOImpl;
import epam.booking_apartment.model.Apartment;
import epam.booking_apartment.service.ApartmentService;
import epam.booking_apartment.service.exception.ServiceException;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("apartmentService")
public class ApartmentServiceImpl implements ApartmentService {

    private Transaction beginTransaction() throws HibernateException {
        return HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
    }

    //@Autowired
    private ApartmentDAO apartmentDAO = new ApartmentDAOImpl();


    @Override
    public void addApartment(Apartment p) throws ServiceException {
        Transaction tx = null;
        try {
            tx = beginTransaction();
            apartmentDAO.addApartment(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new ServiceException(e);
        }
    }

    @Override
    public void updateApartment(Apartment p) throws ServiceException {
        Transaction tx = null;
        try {
            tx = beginTransaction();
            apartmentDAO.updateApartment(p);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Apartment> getAllApartments() throws ServiceException {
        List<Apartment> apartmentList = null;
        Transaction tx = null;
        try {
            tx = beginTransaction();
            apartmentList = apartmentDAO.getAllApartments();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new ServiceException(e);
        }
        return apartmentList;
    }

    @Override
    public Apartment getApartmentById(Long id) throws ServiceException {
        Apartment apartment = null;

        if (id == null) {
            throw new ServiceException("Apartment id is nullable");
        } else {
            Transaction tx = null;
            try {
                tx = beginTransaction();
                apartment = apartmentDAO.getApartmentById(id);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                throw new ServiceException(e);
            }
        }
        return apartment;
    }

    @Override
    public void deleteApartment(Apartment apartment) throws ServiceException {
        Transaction tx = null;
        try {
            tx = beginTransaction();
            apartmentDAO.removeApartment(apartment);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new ServiceException(e);
        }
    }
}
