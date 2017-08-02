package epam.booking_apartment.controller.servlet;

import epam.booking_apartment.controller.command.CommandRepository;
import epam.booking_apartment.HibernateUtil;
import epam.booking_apartment.controller.command.ICommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

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
        String uri = request.getRequestURI();
        ICommand command = CommandRepository.getCommand(uri);


        System.out.println(request.getRequestURI());
        String commandParameter = request.getParameter(COMMAND);
       // ICommand command = CommandRepository.getCommand(commandParameter);
        return command.execute(request, response);
    }

}