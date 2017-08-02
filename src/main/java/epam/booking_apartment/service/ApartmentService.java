package epam.booking_apartment.service;

import epam.booking_apartment.model.Apartment;
import epam.booking_apartment.service.exception.ServiceException;

import java.util.List;

public interface ApartmentService {

    void addApartment(Apartment p) throws ServiceException;

    void updateApartment(Apartment p) throws ServiceException;

    List<Apartment> getAllApartments() throws ServiceException;

    Apartment getApartmentById(Long id) throws ServiceException;

    void removeApartment(Long id) throws ServiceException;

}
