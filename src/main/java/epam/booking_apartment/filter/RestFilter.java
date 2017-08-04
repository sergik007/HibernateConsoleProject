package epam.booking_apartment.filter;

import epam.booking_apartment.controller.command.CommandRepository;
import epam.booking_apartment.controller.command.ICommand;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestFilter implements Filter {
    private CommandRepository repository = new CommandRepository();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String servletPath = ((HttpServletRequest) servletRequest).getServletPath();
        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        String method= ((HttpServletRequest) servletRequest).getMethod();
        String testString = null;
        if (method.equals("POST")) {
            String _methodParam = servletRequest.getParameter("_method");
            testString = uri.replace(servletPath,"") + "?_method=" + _methodParam;
        } else {
            testString = uri.replace(servletPath, "");
        }
        ICommand command = null;
        Set<Pattern> keys = repository.getKeys();
        Matcher matcher;
        for (Pattern pattern : keys) {
            matcher = pattern.matcher(testString);
            if (matcher.matches()) {
                command= CommandRepository.getCommand(pattern);
            }
        }
        servletRequest.setAttribute("command", command);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
