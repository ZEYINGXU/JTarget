package com.jtarget.dao;

import com.jtarget.domain.User;

import java.util.List;

public interface UserDao {
    /**
     *
     * @return
     */
    public List<User> findAll();

    /**
     *
     * @param username
     * @param password
     * @return
     */
    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int i);

    User findById(int parseInt);
}
