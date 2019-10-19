package com.jtarget.dao.impl;

import com.jtarget.dao.UserDao;
import com.jtarget.domain.User;
import com.jtarget.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";

        try {
            User user = template.queryForObject(sql,
                                                new BeanPropertyRowMapper<User>(User.class),
                                                username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void add(User user) {
        //1.定义sql
        String sql = "insert into user values(null,?,?,?,?,?,?,?,?);";
        //2.执行SQL
        template.update(sql,user.getUsername(),
                            user.getPassword(),
                            user.getName(),
                            user.getGender(),
                            user.getAge(),
                            user.getAddress(),
                            user.getEmail(),
                            user.getPhone());
    }

    @Override
    public void delete(int id) {
        //1.定义sql
        String sql = "delete from user where id = ?";
        //2.执行SQL
        template.update(sql,id);
    }

    @Override
    public User findById(int id) {

        String sql = "select * from user where id = ?";
        return  template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }
}
