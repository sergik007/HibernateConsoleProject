package epam.booking_apartment.controller.command;

import epam.booking_apartment.controller.command.impl.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class CommandRepository {

    @Autowired
    private static Map<Pattern, ICommand> repository = new HashMap() {
        {
            {
                this.put(UriPattern.Apartment.APARTMENT, new GetAllApartment());
                this.put(UriPattern.Apartment.SLASH_APARTMENT_SLASH_NUMBER, new GetApartmentById());
                this.put(UriPattern.EMPTY, new RedirectRequest());
                this.put(UriPattern.Apartment.SLASH_APARTMENT_SLASH_NUMBER_CREATE, new AddApartment());
                this.put(UriPattern.Apartment.SLASH_APARTMENT_SLASH_NUMBER_DELETE, new DeleteApartment());
                this.put(UriPattern.Apartment.SLASH_APARTMENT_SLASH_NUMBER_UPDATE, new UpdateApartment());
            }
        }
    };

    public static ICommand getCommand(Pattern pattern) {
        return repository.get(pattern);
    }
    public Set<Pattern> getKeys() {
        return repository.keySet();
    }
}
