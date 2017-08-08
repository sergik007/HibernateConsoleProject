package epam.booking_apartment;

import epam.booking_apartment.dao.ApartmentDAO;
import epam.booking_apartment.dao.impl.ApartmentDAOImpl;
import epam.booking_apartment.service.ApartmentService;
import epam.booking_apartment.service.impl.ApartmentServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * Created by Siarhei_Kalashynski on 8/7/2017.
 */
@Configuration
@ComponentScan("epam.booking_apartment")
@PropertySource("classpath:db-test.properties")
public class ConfigTest {

    @Value("db.connection.class")
    private String connectionClass;

    @Value("db.connection.username")
    private String connectionUsername;

    @Value("db.connection.password")
    private String connectionPassword;

    @Value("db.connection.url")
    private String connectionUrl;

    @Bean
    public ApartmentDAO apartmentDAO() {
        return new ApartmentDAOImpl();
    }
    @Bean
    public ApartmentService apartmentService() {
        return new ApartmentServiceImpl();
    }

    @Bean
    public SessionFactory sessionFactory () {
        return HibernateUtil.getSessionFactory();
    }
}
