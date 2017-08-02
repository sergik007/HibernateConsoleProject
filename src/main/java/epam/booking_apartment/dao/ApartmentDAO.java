package epam.booking_apartment.dao;

import epam.booking_apartment.model.Apartment;

import java.util.List;


public interface ApartmentDAO {

    void addApartment(Apartment p);

    void updateApartment(Apartment p);

    List<Apartment> getAllApartments();

    Apartment getApartmentById(Long id);

    void removeApartment(Long id);
}
