package epam.booking_apartment.filter;

import com.google.gson.Gson;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class JsonFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        Enumeration<String> attributeNames = servletRequest.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attribute = attributeNames.nextElement();
            Object object =servletRequest.getAttribute(attribute);
            String json = new Gson().toJson(object);
            servletRequest.setAttribute(attribute, object);
        }
    }

    @Override
    public void destroy() {

    }
}
