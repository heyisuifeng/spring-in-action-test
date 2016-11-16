package com.ace.service;

import com.ace.dao.UserRoleDAO;
import com.ace.entity.UserRole;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by leaf.ye on 2016/10/17.
 */
@Service
public class UserRoleService {

    @Inject
    private UserRoleDAO userRoleDAO;

    public List<UserRole> getRoleByUser(int userId) {
        return userRoleDAO.getRoleByUser(userId);
    }
}
