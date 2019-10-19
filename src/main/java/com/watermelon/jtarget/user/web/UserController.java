package com.watermelon.jtarget.user.web;

import com.watermelon.jtarget.common.pager.PageInfo;
import com.watermelon.jtarget.common.response.ResponseBean;
import com.watermelon.jtarget.common.util.Md5Utils;
import com.watermelon.jtarget.user.dto.UserDTO;
import com.watermelon.jtarget.user.enumerate.UserTypeEnum;
import com.watermelon.jtarget.user.service.UserService;
import com.watermelon.jtarget.user.vo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Md5Utils md5Utils;

    @GetMapping(value = "/detail")
    public ModelAndView viewInfo(@RequestParam String userId, ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("userBean") == null) {
            modelAndView.setViewName("login");
            return modelAndView;
        }
        UserBean userInfo = userService.findUserById(userId);
        modelAndView.addObject("userInfo", userInfo);
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @GetMapping(value = "/list")
    public ModelAndView findUsers(@RequestParam(required = false) Integer currentPage,
                                 @RequestParam(required = false) Integer pageSize,
                                 @RequestParam(required = false) String key,
                                 ModelAndView modelAndView) {

        if (currentPage == null || currentPage < 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize < 0) {
            pageSize = 10;
        }
        PageInfo pageInfo = userService.findUsers(currentPage, pageSize, key);

        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("pageNum", pageInfo.getCurrentPage());
        modelAndView.addObject("pageSize", pageInfo.getPageSize());
        modelAndView.addObject("isFirstPage", pageInfo.isFirstPage());
        modelAndView.addObject("totalPages", pageInfo.getTotalPage());
        modelAndView.addObject("isLastPage", pageInfo.isLastPage());

        modelAndView.setViewName("users");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ResponseBean addUser(@RequestBody UserDTO user) {
        ResponseBean response = new ResponseBean();
        response.setResponseError("operation failed!");
        if (StringUtils.isEmpty(user.getUserAccount())) {
            return response;
        }
        if (StringUtils.isEmpty(user.getUserName())) {
            return response;
        }
        if (StringUtils.isEmpty(user.getUserPassword())) {
            return response;
        }
        if (StringUtils.isEmpty(user.getUserType())) {
            return response;
        }
        if ( ! UserTypeEnum.JOB_SEEKER.getType().equals(user.getUserType())
                && ! UserTypeEnum.RECRUITER.getType().equals(user.getUserType())
                && ! UserTypeEnum.SYS_ADMIN.getType().equals(user.getUserType())) {
            return response;
        }
        boolean result = userService.addUser(user);
        if (result) {
            response.setResponseSuccess("operation success!");
            return response;
        }
        return response;
    }

    @GetMapping(value = "/delete")
    public ResponseBean deleteUser(@RequestParam String userId) {
        ResponseBean response = new ResponseBean();
        response.setResponseError("operation failed!");
        boolean result = userService.deleteUserById(userId);
        if (result) {
            response.setResponseSuccess("operation success!");
            return response;
        }
        return response;
    }

    @GetMapping(value = "/update")
    public ModelAndView updateUser(@RequestParam String userId, ModelAndView modelAndView) {
        UserBean userInfo = userService.findUserById(userId);
        modelAndView.addObject("userInfo", userInfo);
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @PostMapping(value = "/updateAction")
    public ModelAndView updateUserAction(@RequestParam Map<String, String> param, ModelAndView modelAndView) {
        UserDTO user = new UserDTO();
        user.setUserAccount(param.get("userAccount"));
        user.setUserName(param.get("userName"));
        user.setUserType(param.get("userType"));
        user.setUserPassword(md5Utils.encoding(param.get("password")));
        user.setDomain(param.get("domain"));
        user.setProfession(param.get("profession"));
        user.setExperience(param.get("experience") == null ? 0 : Integer.valueOf(param.get("experience")));

        if (StringUtils.isEmpty(user.getUserAccount())) {
            UserBean userInfo = userService.findUserByAccount(user.getUserAccount());
            modelAndView.addObject("error", "Parameter error");
            modelAndView.addObject("userInfo", userInfo);
            modelAndView.setViewName("userUpdate");
            return modelAndView;
        }
        if (StringUtils.isEmpty(user.getUserName())) {
            UserBean userInfo = userService.findUserByAccount(user.getUserAccount());
            modelAndView.addObject("error", "Parameter error");
            modelAndView.addObject("userInfo", userInfo);
            modelAndView.setViewName("userUpdate");
            return modelAndView;
        }
        if (StringUtils.isEmpty(user.getUserPassword())) {
            UserBean userInfo = userService.findUserByAccount(user.getUserAccount());
            modelAndView.addObject("error", "Parameter error");
            modelAndView.addObject("userInfo", userInfo);
            modelAndView.setViewName("userUpdate");
            return modelAndView;
        }
        if (StringUtils.isEmpty(user.getUserType())) {
            UserBean userInfo = userService.findUserByAccount(user.getUserAccount());
            modelAndView.addObject("error", "Parameter error");
            modelAndView.addObject("userInfo", userInfo);
            modelAndView.setViewName("userUpdate");
            return modelAndView;
        }
        if ( ! UserTypeEnum.JOB_SEEKER.getType().equals(user.getUserType())
                && ! UserTypeEnum.RECRUITER.getType().equals(user.getUserType())
                && ! UserTypeEnum.SYS_ADMIN.getType().equals(user.getUserType())) {
            UserBean userInfo = userService.findUserByAccount(user.getUserAccount());
            modelAndView.addObject("error", "Parameter error");
            modelAndView.addObject("userInfo", userInfo);
            modelAndView.setViewName("userUpdate");
            return modelAndView;
        }

        userService.updateUser(user);

        PageInfo pageInfo = userService.findUsers(1, 10, null);

        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("pageNum", pageInfo.getCurrentPage());
        modelAndView.addObject("pageSize", pageInfo.getPageSize());
        modelAndView.addObject("isFirstPage", pageInfo.isFirstPage());
        modelAndView.addObject("totalPages", pageInfo.getTotalPage());
        modelAndView.addObject("isLastPage", pageInfo.isLastPage());

        modelAndView.setViewName("users");
        return modelAndView;
    }
}
