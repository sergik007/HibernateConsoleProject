package epam.booking_apartment.filter;

import epam.booking_apartment.HibernateUtil;
import org.hibernate.HibernateException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Siarhei_Kalashynski on 8/3/2017.
 */
public class HibernateFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (((HttpServletRequest) servletRequest).getMethod().equals("POST")) {
            HibernateUtil.getSessionFactory().getCurrentSession();
            filterChain.doFilter(servletRequest, servletResponse);
            HibernateUtil.shutDown();
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
