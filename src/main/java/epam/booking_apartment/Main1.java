package epam.booking_apartment;

import epam.booking_apartment.configuration.Config;
import epam.booking_apartment.model.Apartment;
import epam.booking_apartment.service.ApartmentService;
import epam.booking_apartment.service.exception.ServiceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by sergey on 30.6.17.
 */
public class Main1 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ApartmentService service = context.getBean(ApartmentService.class);
        try {

            List<Apartment> apartmentList = service.getAllApartments();
            apartmentList.forEach(c -> System.out.println(c));
        } catch (ServiceException e) {
            System.out.println("ошибка");
        }
    }
}
