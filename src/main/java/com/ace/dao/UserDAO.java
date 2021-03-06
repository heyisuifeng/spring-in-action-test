package com.ace.dao;

import com.ace.dao.HibernateDAO;
import com.ace.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by leaf.ye on 2016/8/25.
 */
@Repository
public class UserDAO extends HibernateDAO {

    public User getById(int id) {
        Session session = this.currentSession();
        session.beginTransaction();
        return this.get(User.class, id);
    }

    public User findByNameAndPassword(String userName, String password) {
        Session session = this.currentSession();
        session.beginTransaction();
        List<User> userList = (List<User>) session.createQuery("from com.ace.entity.User").list();
        session.getTransaction().commit();
        return userList.get(0);
    }

    public void registerUser(Object object) {
        Session session = this.currentSession();
        Transaction t = session.beginTransaction();
        session.save(object);
        t.commit();
    }

    public User findByUserName(String userName) {
        Session session = this.currentSession();
        session.beginTransaction();
        String hql = "from User where userName= :username";
        Query query = session.createQuery(hql);
        query.setString("username", userName);
        List<User> list = query.list();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
