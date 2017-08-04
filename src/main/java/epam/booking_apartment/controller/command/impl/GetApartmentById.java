package epam.booking_apartment.controller.command.impl;

import epam.booking_apartment.controller.command.ICommand;
import epam.booking_apartment.model.Apartment;
import epam.booking_apartment.service.ApartmentService;
import epam.booking_apartment.service.exception.ServiceException;
import epam.booking_apartment.service.impl.ApartmentServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetApartmentById implements ICommand {
    private static final String regexId = "//D";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ApartmentService service = new ApartmentServiceImpl();
        String pathInfo = request.getPathInfo();
        Long id = Long.valueOf(pathInfo.replaceAll(regexId, ""));
        try {
            Apartment apartment = service.getApartmentById(id);
            request.setAttribute("apartment", apartment);
        } catch (ServiceException e) {
            System.out.println("ошибка");
        }
        return "/WEB-INF/view/apartment.jsp";
    }
}
