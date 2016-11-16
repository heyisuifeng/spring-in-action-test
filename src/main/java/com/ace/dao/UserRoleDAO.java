package com.ace.dao;

import com.ace.dao.HibernateDAO;
import com.ace.entity.UserRole;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by leaf.ye on 2016/10/17.
 */
@Repository
public class UserRoleDAO extends HibernateDAO {

    public List<UserRole> getRoleByUser(int userId) {
        Session session = this.currentSession();
        session.beginTransaction();
        String hql = "from UserRole where userId in : userId";
        Query query = session.createQuery(hql);
        query.setInteger("userId", userId);
        List<UserRole> userRoles = query.list();
        return userRoles;
    }
}
