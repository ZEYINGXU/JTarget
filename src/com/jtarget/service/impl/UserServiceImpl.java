package com.jtarget.service.impl;

import com.jtarget.dao.UserDao;
import com.jtarget.dao.impl.UserDaoImpl;
import com.jtarget.domain.User;
import com.jtarget.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public List<User> findAll(){
        return dao.findAll();
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {

        return dao.findById(Integer.parseInt(id));
    }

}
