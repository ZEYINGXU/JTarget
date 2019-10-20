package com.watermelon.jtarget.user.service;

import com.watermelon.jtarget.common.pager.PageInfo;
import com.watermelon.jtarget.user.dto.UserDTO;
import com.watermelon.jtarget.user.vo.UserBean;

public interface UserService {

    boolean addUser(UserDTO user);

    boolean deleteUserById(String userId);

    boolean deleteUserByAccount(String userAccount);

    boolean updateUser(UserDTO user);

    UserBean findUserById(String userId);

    UserBean findUserByAccount(String userAccount);

    boolean userLogin(String userAccount, String password, String userType);

    PageInfo findUsers(Integer currentPage, Integer pageSize, String key);

    PageInfo findApplicant(String jobId, String key);
}
