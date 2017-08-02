package epam.booking_apartment.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharSetFilter implements Filter {
    private String charsetEncoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        charsetEncoding = filterConfig.getInitParameter("charsetEncoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(charsetEncoding);
        servletResponse.setCharacterEncoding(charsetEncoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
