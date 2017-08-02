package epam.booking_apartment.controller.command;

/**
 * Created by sergey on 30.6.17.
 */
public class Command {
    public static class Apartment {
        public static final String ADD_APARTMENT = "ADD_APARTMENT";
        public static final String DELETE_APARTMENT = "DELETE_APARTMENT";
        public static final String GET_ALL_APARTMENTS = "/APARTMENT";
        public static final String EDIT_APARTMENT = "EDIT_APARTMENT";
        public static final String GET_APARTMENT_BY_ID = "GET_APARTMENT_BY_ID";
        public static final String GET_NO_BOOKING_APARTMENT = "GET_NO_BOOKING_APARTMENT";
    }
}
