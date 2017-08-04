package epam.booking_apartment.controller.command;

import java.util.regex.Pattern;

/**
 * Created by sergey on 30.6.17.
 */
public class UriPattern {
    public static final Pattern EMPTY = Pattern.compile("^\\/?$");

    public static class Apartment {
        public static final Pattern APARTMENT = Pattern.compile("^\\/apartment\\/?$");
        public static final Pattern SLASH_APARTMENT_SLASH_NUMBER = Pattern.compile("^\\/apartment[\\/]?[0-9]+[\\/]?$");
        public static final Pattern SLASH_APARTMENT_SLASH_NUMBER_DELETE = Pattern.compile("^\\/apartment[\\/]?[0-9]+[\\/]?\\?_method=delete$");
        public static final Pattern SLASH_APARTMENT_SLASH_NUMBER_UPDATE = Pattern.compile("^\\/apartment[\\/]?[0-9]+[\\/]?\\?_method=update$");
        public static final Pattern SLASH_APARTMENT_SLASH_NUMBER_CREATE = Pattern.compile("^\\/apartment[\\/]?[0-9]+[\\/]?\\?_method=create$");
    }
}