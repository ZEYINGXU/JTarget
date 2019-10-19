package com.watermelon.jtarget.user.service.impl;

import com.watermelon.jtarget.common.pager.PageInfo;
import com.watermelon.jtarget.common.util.Md5Utils;
import com.watermelon.jtarget.common.util.UUIDUtils;
import com.watermelon.jtarget.user.dao.UserDao;
import com.watermelon.jtarget.user.dto.UserDTO;
import com.watermelon.jtarget.user.service.UserService;
import com.watermelon.jtarget.user.vo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UUIDUtils uuidUtils;

    @Autowired
    private Md5Utils md5Utils;

    @Override
    public boolean addUser(UserDTO user) {
        UserBean userBean = findUserByAccount(user.getUserAccount());
        if (userBean != null) {
            return false;
        }
        user.setUserId(uuidUtils.generate());
        user.setUserPassword(md5Utils.encoding(user.getUserPassword()));
        int result = userDao.addUser(user);
        return result > 0;
    }

    @Override
    public boolean deleteUserById(String userId) {
        int result = userDao.deleteUserById(userId);
        return result > 0;
    }

    @Override
    public boolean deleteUserByAccount(String userAccount) {
        int result = userDao.deleteUserByAccount(userAccount);
        return result > 0;
    }

    @Override
    public boolean updateUser(UserDTO user) {
        UserDTO userExist = userDao.findUserByUserId(user.getUserId());
        if ( ! userExist.getUserAccount().equals(user.getUserAccount())) {
             return false;
        }
        int result = userDao.updateUser(user);
        return result > 0;
    }

    @Override
    public UserBean findUserById(String userId) {
        UserDTO user = userDao.findUserByUserId(userId);
        return generateUserBean(user);
    }

    @Override
    public UserBean findUserByAccount(String userAccount) {
        UserDTO user = userDao.findUserByUserAccount(userAccount);
        return generateUserBean(user);
    }

    @Override
    public boolean userLogin(String userAccount, String password, String userType) {
        UserDTO user = userDao.findUserByUserAccount(userAccount);
        if (user == null) {
            return false;
        }
        if (md5Utils.match(password, user.getUserPassword())) {
            if (user.getUserType().equals(userType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public PageInfo findUsers(Integer currentPage, Integer pageSize, String key) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        int totalCount = userDao.findUserCount(key);
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pageInfo.setTotalPage(totalPage);
        pageInfo.setData(userDao.findUsers((currentPage - 1) * pageSize, pageSize, key));
        pageInfo.setFirstPage(currentPage == 1);
        pageInfo.setLastPage(currentPage == pageInfo.getTotalPage());
        return pageInfo;
    }

    private UserBean generateUserBean(UserDTO user) {
        if (Objects.isNull(user)) {
            return null;
        }
        UserBean userBean = new UserBean();
        userBean.setUserId(user.getUserId());
        userBean.setUserAccount(user.getUserAccount());
        userBean.setUserName(user.getUserName());
        userBean.setUserType(user.getUserType());
        return userBean;
    }
}
