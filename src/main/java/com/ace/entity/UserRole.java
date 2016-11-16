package com.ace.entity;

import javax.persistence.*;

/**
 * Created by leaf.ye on 2016/10/17.
 */
@Entity
@Table(name = "t_user_role", schema = "shiro_test", catalog = "")
@IdClass(UserRolePK.class)
public class UserRole {
    private int userId;
    private int roleId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + roleId;
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        UserRole tUserRole = (UserRole) object;

        if (userId != tUserRole.userId) return false;
        if (roleId != tUserRole.roleId) return false;

        return true;
    }
}
