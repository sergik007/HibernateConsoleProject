package epam.booking_apartment.dao;

import epam.booking_apartment.model.Apartment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Siarhei_Kalashynski on 8/7/2017.
 */
public class ApartmentDAOTest {

    @Autowired
    private ApartmentDAO apartmentDAO;

    @Test
    public void addApartment() throws Exception {
    }

    @Test
    public void updateApartment() throws Exception {
    }

    @Test

    public void getAllApartments() throws Exception {
        List<Apartment> apartmentList = apartmentDAO.getAllApartments();
        assertThat(apartmentList.size(), equalTo(2));
    }

    @Test
    public void getApartmentById() throws Exception {
    }

    @Test
    public void removeApartment() throws Exception {

    }

}