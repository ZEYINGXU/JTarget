package com.watermelon.jtarget.user.dao;

import com.watermelon.jtarget.user.dto.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    UserDTO findUserByUserAccount(@Param("userAccount") String userAccount);

    UserDTO findUserByUserId(@Param("userId") String userId);

    Integer addUser(UserDTO user);

    Integer updateUser(UserDTO user);

    Integer deleteUserById(@Param("userId") String userId);

    Integer deleteUserByAccount(@Param("userAccount") String userAccount);

    int findUserCount(@Param("key") String key);

    List<UserDTO> findUsers(@Param("fromIndex") Integer fromIndex,
                           @Param("pageSize") Integer pageSize,
                           @Param("key") String key);
}
