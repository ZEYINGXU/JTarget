package com.jtarget.service;

import com.jtarget.domain.User;

import java.util.List;

public interface UserService {
    /**
     * login function
     * @param user
     * @return
     */
    User login(User user);

    /**
     * get all users information
     * @return
     */
    public List<User> findAll();

    /**
     * save user
     * @param user
     */
    void addUser(User user);

    /**
     * delete user by ID
     * @param id
     */
    void deleteUser(String id);

    User findUserById(String id);
}
