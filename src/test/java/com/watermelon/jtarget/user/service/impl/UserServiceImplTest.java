package com.watermelon.jtarget.user.service.impl;

import com.watermelon.jtarget.user.dto.UserDTO;
import com.watermelon.jtarget.user.enumerate.UserTypeEnum;
import com.watermelon.jtarget.user.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        UserDTO user = new UserDTO();
        user.setUserAccount("test");
        user.setUserName("test");
        user.setUserPassword("test");
        user.setUserType(UserTypeEnum.JOB_SEEKER.getType());
        Assert.assertEquals(true, userService.addUser(user));

    }

    @Test
    public void deleteUserById() {
        String userId = "3ee7f7330cbc487bba9ac55e379603a0";
        Assert.assertEquals(true, userService.deleteUserById(userId));
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void findUserById() {
        String userId = "3ee7f7330cbc487bba9ac55e379603a0";
        System.out.println(userService.findUserById(userId));
    }

    @Test
    public void findUserByAccount() {
        String userAccount = "test";
        System.out.println(userService.findUserByAccount(userAccount));
    }

    @Test
    public void userLogin() {
        String userAccount = "test";
        Assert.assertEquals(false, userService.userLogin(userAccount, null, null));
    }
}