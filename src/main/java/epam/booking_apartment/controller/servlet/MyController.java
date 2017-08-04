package epam.booking_apartment.controller.servlet;

import epam.booking_apartment.HibernateUtil;
import epam.booking_apartment.controller.command.ICommand;
import epam.booking_apartment.controller.command.impl.RedirectRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sergey on 30.6.17.
 */

public class MyController extends HttpServlet {
    private static final String COMMAND = "command";

    @Override
    public void destroy() {
        HibernateUtil.shutDown();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        response.sendRedirect("index.jsp");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jspPage = processRequest(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
        dispatcher.forward(request, response);
    }

    private String processRequest(HttpServletRequest request, HttpServletResponse response) {
        ICommand command= (ICommand) request.getAttribute("command");
        if (command == null) {
            command = new RedirectRequest();
        }
        return command.execute(request, response);
    }

}
