package com.ace.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by leaf.ye on 2016/8/29.
 */
@Repository
@Transactional
public class JpaUserDAO {
   /* private static final String RECENT_USER = "SELECT u FROM user s";
    private static final String ALL_USER = "SELECT u FROM user s";

    @PersistenceContext
    private EntityManager em;

    public void addUser(User user) {
        em.persist(user);
    }

    public User getUser(int id) {
        return em.find(User.class, id);
    }

    public void saveUser(User user) {
        em.merge(user);
    }*/
}
