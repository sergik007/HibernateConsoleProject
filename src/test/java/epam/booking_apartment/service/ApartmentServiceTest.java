package epam.booking_apartment.service;

import epam.booking_apartment.ConfigTest;
import epam.booking_apartment.dao.ApartmentDAO;
import epam.booking_apartment.model.Apartment;
import epam.booking_apartment.service.exception.ServiceException;
import epam.booking_apartment.service.impl.ApartmentServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Siarhei_Kalashynski on 8/7/2017.
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = ConfigTest.class)
public class ApartmentServiceTest {

    private static final List<Apartment> TEST_APARTMENT_LIST = Arrays.asList(new Apartment(), new Apartment(), new Apartment());
    private static final Apartment TEST_APARTMENT_OBJECT = new Apartment();

    @Mock
    private ApartmentDAO apartmentDAO;

    @InjectMocks
//    @Autowired
    private ApartmentService apartmentService = new ApartmentServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFindAllApartments() throws ServiceException {
        when(apartmentDAO.getAllApartments()).thenReturn(TEST_APARTMENT_LIST);
        List<Apartment> apartments = apartmentService.getAllApartments();
        assertThat(apartments, equalTo(TEST_APARTMENT_LIST));
        verify(apartmentDAO, times(1)).getAllApartments();
        verifyNoMoreInteractions(apartmentDAO);
    }

    @Test
    public void shouldFindApartmentById() throws ServiceException {
        Long id = new Long(1L);
        when(apartmentDAO.getApartmentById(id)).thenReturn(TEST_APARTMENT_OBJECT);
        Apartment apartment = apartmentService.getApartmentById(id);
        assertThat(apartment, equalTo(TEST_APARTMENT_OBJECT));
        verify(apartmentDAO, times(1)).getApartmentById(id);
        verifyNoMoreInteractions(apartmentDAO);
    }

    @Test(expected = ServiceException.class)
    public void shouldThrowsIllegalArgumentExceptionFindingNull() throws ServiceException {
        apartmentService.getApartmentById(null);
    }
}