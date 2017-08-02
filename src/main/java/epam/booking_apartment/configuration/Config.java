package epam.booking_apartment.configuration;

import epam.booking_apartment.controller.command.Command;
import epam.booking_apartment.controller.command.ICommand;
import epam.booking_apartment.controller.command.impl.GetAllApartment;
import epam.booking_apartment.HibernateUtil;
import epam.booking_apartment.dao.ApartmentDAO;
import epam.booking_apartment.dao.impl.ApartmentDAOImpl;
import epam.booking_apartment.service.ApartmentService;
import epam.booking_apartment.service.impl.ApartmentServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

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
    @Bean
    public Map<String, ICommand> repository() {
        return new HashMap(){
            {
                this.put(Command.Apartment.GET_ALL_APARTMENTS, new GetAllApartment());
            }
        };
    }
}
