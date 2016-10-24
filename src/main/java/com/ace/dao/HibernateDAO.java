package com.ace.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by leaf.ye on 2016/8/25.
 */
@Component
public class HibernateDAO {
    @Resource
    private SessionFactory sessionFactory;

    public HibernateDAO() {

    }

    public HibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Object object) {
        currentSession().save(object);
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public <T> T get(Class<T> cla, int id) {
        return (T) currentSession().get(cla, id);
    }
}
