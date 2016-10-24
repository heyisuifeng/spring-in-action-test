package com.ace.dao;

import com.ace.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by leaf.ye on 2016/8/8.
 */
@Repository
public class LoginDAO extends BaseDAO {

    public User login() {
        List<Map<String, Object>> userList = this.getJdbcTemplate().queryForList("SELECT * FROM t_user ");
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        User user = new User();
        user.setId((Integer) userList.get(0).get("id"));
        user.setUserName((String) userList.get(0).get("username"));
        user.setPassword((String) userList.get(0).get("password"));
        return user;
    }

    public User login(String userName, String password) {
        List<Map<String, Object>> userList = this.getJdbcTemplate().
            queryForList("SELECT * FROM t_user where username='" + userName + "' and password='" + password + "'");
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        User user = new User();
        user.setId((Integer) userList.get(0).get("id"));
        user.setUserName((String) userList.get(0).get("username"));
        user.setPassword((String) userList.get(0).get("password"));
        return user;
    }
}
