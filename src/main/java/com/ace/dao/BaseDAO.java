package com.ace.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

/**
 * Created by leaf.ye on 2016/8/17.
 */
public class BaseDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
