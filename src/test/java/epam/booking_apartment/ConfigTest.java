package epam.booking_apartment;

import epam.booking_apartment.dao.ApartmentDAO;
import epam.booking_apartment.dao.impl.ApartmentDAOImpl;
import epam.booking_apartment.service.ApartmentService;
import epam.booking_apartment.service.impl.ApartmentServiceImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Siarhei_Kalashynski on 8/7/2017.
 */
@Configuration
@ComponentScan("epam.booking_apartment")
@PropertySource("classpath:db-test.properties")
public class ConfigTest {

    @Value("db.connection.className")
    private String connectionClassName;

    @Value("db.connection.username")
    private String connectionUsername;

    @Value("db.connection.password")
    private String connectionPassword;

    @Value("db.connection.url")
    private String connectionUrl;

    @Value("hibernate.dialect")
    private String hibernateDialect;

    @Value("hibernate.show_sql")
    private String showSql;

    @Value("hibernate.format_sql")
    private String formatSql;

    @Bean
    public ApartmentDAO apartmentDAO() {
        return new ApartmentDAOImpl();
    }
    @Bean
    public ApartmentService apartmentService() {
        return new ApartmentServiceImpl();
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSourse = new BasicDataSource();
        dataSourse.setUsername(connectionUsername);
        dataSourse.setPassword(connectionPassword);

        dataSourse.setUrl(connectionUrl);
        dataSourse.setDriverClassName(connectionClassName);
        return dataSourse;
    }
    @Bean
    public LocalSessionFactoryBean  sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql",showSql);
        properties.setProperty("hibernate.dialect",hibernateDialect);
        properties.setProperty("hibernate.format_sql",formatSql);
        return properties;
    }
}
