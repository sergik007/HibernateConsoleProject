package epam.booking_apartment.dao;

import epam.booking_apartment.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao <PK extends Serializable, T>{
    private Class persistanceClass;

    public AbstractDao() {
        this.persistanceClass = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

//    @Autowired
    protected SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    protected Session getSession() throws HibernateException{
        return sessionFactory.getCurrentSession();
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