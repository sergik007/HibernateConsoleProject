package epam.booking_apartment.filter;

import epam.booking_apartment.controller.command.CommandRepository;
import epam.booking_apartment.controller.command.ICommand;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uri = null;
        if (servletRequest instanceof HttpServletRequest) {
            uri = ((HttpServletRequest) servletRequest).getRequestURI();
            ICommand command = CommandRepository.getCommand(uri);
            servletRequest.setAttribute("command", command);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
