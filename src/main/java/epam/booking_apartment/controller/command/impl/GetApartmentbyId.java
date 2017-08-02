package epam.booking_apartment.controller.command.impl;

import epam.booking_apartment.controller.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetApartmentbyId implements ICommand {
    private Long idApartment;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
