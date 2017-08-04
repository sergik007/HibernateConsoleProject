package epam.booking_apartment.dao;

import epam.booking_apartment.model.Apartment;
import org.hibernate.HibernateException;

import java.util.List;


public interface ApartmentDAO {

    void addApartment(Apartment p)throws HibernateException;

    void updateApartment(Apartment p)throws HibernateException;

    List<Apartment> getAllApartments()throws HibernateException;

    Apartment getApartmentById(Long id)throws HibernateException;

    void removeApartment(Apartment apartment)throws HibernateException;
}
