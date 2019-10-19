package com.watermelon.jtarget.login.service;

import com.watermelon.jtarget.user.dto.UserDTO;
import com.watermelon.jtarget.user.vo.UserBean;

public interface LoginService {

    /**
     * if success, return userBean
     * else return null.
     * @param userAccount
     * @param password
     * @param userType
     * @return
     */
    UserBean userLogin(String userAccount, String password, String userType);

    UserBean userRegistered(UserDTO user);
}
