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
        Apartment apartment = new Apartment();
      //  apartment.setId(56L);
//        apartment.setName("name");
//        apartment.setDate(new Date());
        try {
            List<Apartment> apartmentList = service.getAllApartments();
            apartmentList.forEach(c -> System.out.println(c));
//            service.addApartment(apartment);
//            apartment.setName("qwertyuiop[");
//            service.updateApartment(apartment);
//            service.deleteApartment(apartment);
        } catch (ServiceException e) {
            System.err.println(e);
        }
        ((AnnotationConfigApplicationContext)context).close();
    }
}
