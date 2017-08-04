package epam.booking_apartment.configuration;

import epam.booking_apartment.HibernateUtil;
import epam.booking_apartment.dao.ApartmentDAO;
import epam.booking_apartment.dao.impl.ApartmentDAOImpl;
import epam.booking_apartment.service.ApartmentService;
import epam.booking_apartment.service.impl.ApartmentServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("epam.booking_apartment")
public class Config {

    @Bean
    public ApartmentDAO apartmentDAO() {
        return new ApartmentDAOImpl();
    }
    @Bean
    public ApartmentService apartmentService() {
        return new ApartmentServiceImpl();
    }

    @Bean
    public SessionFactory sessionFactory() {
        return HibernateUtil.getSessionFactory();
    }
    /*@Bean
    public Map<Pattern, ICommand> repository() {
        return new HashMap(){
            {
                this.put(UriPattern.Apartment.APARTMENT, new GetAllApartment());
                this.put(UriPattern.Apartment.SLASH_APARTMENT_SLASH_NUMBER, new GetApartmentById());
                this.put(UriPattern.EMPTY, new RedirectRequest());
                this.put(UriPattern.Apartment.SLASH_APARTMENT_SLASH_NUMBER_CREATE, new AddApartment());
                this.put(UriPattern.Apartment.SLASH_APARTMENT_SLASH_NUMBER_DELETE, new DeleteApartment());
                this.put(UriPattern.Apartment.SLASH_APARTMENT_SLASH_NUMBER_UPDATE, new UpdateApartment());
            }
        };
    }*/
}
