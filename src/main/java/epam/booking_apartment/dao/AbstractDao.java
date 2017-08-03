package epam.booking_apartment.dao;

import epam.booking_apartment.filter.HibernateFilter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao <PK extends Serializable, T>{
    private Class persistanceClass;

    public AbstractDao() {
        this.persistanceClass = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory factory;

    protected Session getSession() throws HibernateException{
        return factory.getCurrentSession();
    }

    protected T getByKey(PK key) throws HibernateException{
        return (T)getSession().get(persistanceClass, key);
    }

    protected void persist(T o) throws HibernateException{
        getSession().persist(o);
    }
    protected void update (T o) throws  HibernateException {
        getSession().update(o);
    }
    protected void delete(T o) throws HibernateException {
        getSession().delete(o);
    }
}