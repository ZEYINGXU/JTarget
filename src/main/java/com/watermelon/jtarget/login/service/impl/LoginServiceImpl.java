package com.watermelon.jtarget.login.service.impl;

import com.watermelon.jtarget.login.service.LoginService;
import com.watermelon.jtarget.user.dto.UserDTO;
import com.watermelon.jtarget.user.service.UserService;
import com.watermelon.jtarget.user.vo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public UserBean userLogin(String userAccount, String password, String userType) {
        boolean flag = userService.userLogin(userAccount, password, userType);
        if (flag) {
            return userService.findUserByAccount(userAccount);
        }
        return null;
    }

    @Override
    public UserBean userRegistered(UserDTO user) {
        boolean result = userService.addUser(user);
        if (result) {
            return userService.findUserByAccount(user.getUserAccount());
        }
        return null;
    }
}
