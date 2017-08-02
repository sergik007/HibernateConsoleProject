package epam.booking_apartment.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractDao <PK extends Serializable, T>{
    private Class persistanceClass;

    public AbstractDao() {
        this.persistanceClass = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory factory;

    protected Session getSession() {
        return factory.getCurrentSession();
    }
    protected T getByKey(PK key){
        return (T)getSession().get(persistanceClass, key);
    }

    protected void persist(T o) {
        getSession().persist(o);
    }
}