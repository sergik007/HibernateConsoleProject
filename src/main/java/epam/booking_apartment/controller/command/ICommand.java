package epam.booking_apartment.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {
    String execute(HttpServletRequest request, HttpServletResponse response);
}
