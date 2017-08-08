package epam.booking_apartment.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import epam.booking_apartment.ConfigTest;
import epam.booking_apartment.model.Apartment;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Siarhei_Kalashynski on 8/7/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConfigTest.class, loader = AnnotationConfigContextLoader.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseTearDown()
public class ApartmentDAOTest {

    @Autowired
    private ApartmentDAO apartmentDAO;

    @Test
    @DatabaseSetup("classpath:data/apartmentData.xml")
    public void shouldGetAllApartments() throws Exception {
        List<Apartment> apartmentList = apartmentDAO.getAllApartments();
        assertThat(apartmentList.size(), equalTo(3));
        Apartment apartment = apartmentList.get(0);
        assertThat(apartment.getId(), equalTo(1));
        assertThat(apartment.getName(), equalTo("First Apartment"));
        //assertThat(apartment.getId(), equalTo(LocalDate.of(2001, 01, 01)));
    }
}