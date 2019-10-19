package com.watermelon.jtarget.login.web;

import com.watermelon.jtarget.common.pager.PageInfo;
import com.watermelon.jtarget.job.service.JobService;
import com.watermelon.jtarget.login.service.LoginService;
import com.watermelon.jtarget.user.dto.UserDTO;
import com.watermelon.jtarget.user.enumerate.UserTypeEnum;
import com.watermelon.jtarget.user.service.UserService;
import com.watermelon.jtarget.user.vo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * handle login service
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JobService jobService;


    @Autowired
    private UserService userService;

    @GetMapping("login")
    public ModelAndView login(ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("userBean") != null) {
            PageInfo pageInfo = jobService.findJobs(1, 10, null, null, null);

            modelAndView.addObject("pageInfo", pageInfo);
            modelAndView.addObject("pageNum", pageInfo.getCurrentPage());
            modelAndView.addObject("pageSize", pageInfo.getPageSize());
            modelAndView.addObject("isFirstPage", pageInfo.isFirstPage());
            modelAndView.addObject("totalPages", pageInfo.getTotalPage());
            modelAndView.addObject("isLastPage", pageInfo.isLastPage());

            modelAndView.setViewName("jobs");
            return modelAndView;
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("register")
    public ModelAndView register(ModelAndView modelAndView, HttpSession session) {
        if (session.getAttribute("userBean") != null) {

            PageInfo pageInfo = jobService.findJobs(1, 10, null, null, null);

            modelAndView.addObject("pageInfo", pageInfo);
            modelAndView.addObject("pageNum", pageInfo.getCurrentPage());
            modelAndView.addObject("pageSize", pageInfo.getPageSize());
            modelAndView.addObject("isFirstPage", pageInfo.isFirstPage());
            modelAndView.addObject("totalPages", pageInfo.getTotalPage());
            modelAndView.addObject("isLastPage", pageInfo.isLastPage());

            modelAndView.setViewName("jobs");
            return modelAndView;
        }
        modelAndView.setViewName("registered");
        return modelAndView;
    }

    @GetMapping(value = "loginAction")
    public ModelAndView loginAction(@RequestParam("userAccount") String userAccount, @RequestParam("password") String password,
                                    @RequestParam("userType") String userType, ModelAndView modelAndView, HttpSession session) {
        if (StringUtils.isEmpty(userAccount)) {
            modelAndView.addObject("error", "Parameter error");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        if (StringUtils.isEmpty(password)) {
            modelAndView.addObject("error", "Parameter error");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        if (StringUtils.isEmpty(userType)) {
            modelAndView.addObject("error", "Parameter error");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        if (!UserTypeEnum.JOB_SEEKER.getType().equals(userType)
                && !UserTypeEnum.RECRUITER.getType().equals(userType)
                && !UserTypeEnum.SYS_ADMIN.getType().equals(userType)) {
            modelAndView.addObject("error","Parameter error");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        UserBean userBean = loginService.userLogin(userAccount, password, userType);
        if (userBean == null) {
            modelAndView.addObject("error","The password is incorrectly filled in or the account does not exist");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        modelAndView.addObject("userBean", userBean);
        session.setAttribute("userBean", userBean);
        if ("3".equals(userBean.getUserType())) {
            PageInfo pageInfo = userService.findUsers(1, 10, null);

            modelAndView.addObject("pageInfo", pageInfo);
            modelAndView.addObject("pageNum", pageInfo.getCurrentPage());
            modelAndView.addObject("pageSize", pageInfo.getPageSize());
            modelAndView.addObject("isFirstPage", pageInfo.isFirstPage());
            modelAndView.addObject("totalPages", pageInfo.getTotalPage());
            modelAndView.addObject("isLastPage", pageInfo.isLastPage());

            modelAndView.setViewName("users");

            return modelAndView;
        } else {
            PageInfo pageInfo = jobService.findJobs(1, 10, null, null, null);

            modelAndView.addObject("pageInfo", pageInfo);
            modelAndView.addObject("pageNum", pageInfo.getCurrentPage());
            modelAndView.addObject("pageSize", pageInfo.getPageSize());
            modelAndView.addObject("isFirstPage", pageInfo.isFirstPage());
            modelAndView.addObject("totalPages", pageInfo.getTotalPage());
            modelAndView.addObject("isLastPage", pageInfo.isLastPage());

            modelAndView.setViewName("jobs");
            return modelAndView;
        }
    }


    @PostMapping(value = "registerAction")
    public ModelAndView registerAction(@RequestParam Map<String, String> param, ModelAndView modelAndView, HttpSession session) {
        UserDTO user = new UserDTO();
        user.setUserName(param.get("userName"));
        user.setUserAccount(param.get("userAccount"));
        user.setUserPassword(param.get("password"));
        user.setUserType(param.get("userType"));
        System.out.println(param.get("userPrefer"));
        user.setUserPrefer(param.get("userPrefer"));
        if (StringUtils.isEmpty(user.getUserAccount())) {
            modelAndView.addObject("error", "Parameter error");
            modelAndView.setViewName("registered");
            return modelAndView;
        }
        if (StringUtils.isEmpty(user.getUserName())) {
            modelAndView.addObject("error", "Parameter error");
            modelAndView.setViewName("registered");
            return modelAndView;
        }
        if (StringUtils.isEmpty(user.getUserPassword())) {
            modelAndView.addObject("error", "Parameter error");
            modelAndView.setViewName("registered");
            return modelAndView;
        }
        if (StringUtils.isEmpty(user.getUserType())) {
            modelAndView.addObject("error", "Parameter error");
            modelAndView.setViewName("registered");
            return modelAndView;
        }
        if (!UserTypeEnum.JOB_SEEKER.getType().equals(user.getUserType())
                && !UserTypeEnum.RECRUITER.getType().equals(user.getUserType())
                && !UserTypeEnum.SYS_ADMIN.getType().equals(user.getUserType())) {
            modelAndView.addObject("error", "Parameter error");
            modelAndView.setViewName("registered");
            return modelAndView;
        }
        UserBean userBean = loginService.userRegistered(user);
        if (userBean == null) {
            modelAndView.addObject("error", "Account already exists");
            modelAndView.setViewName("registered");
            return modelAndView;
        }
        modelAndView.addObject("userBean", userBean);
        modelAndView.setViewName("jobs");

        session.setAttribute("userBean", userBean);

        PageInfo pageInfo = jobService.findJobs(1, 10, null, null, null);

        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("pageNum", pageInfo.getCurrentPage());
        modelAndView.addObject("pageSize", pageInfo.getPageSize());
        modelAndView.addObject("isFirstPage", pageInfo.isFirstPage());
        modelAndView.addObject("totalPages", pageInfo.getTotalPage());
        modelAndView.addObject("isLastPage", pageInfo.isLastPage());

        return modelAndView;
    }

    @GetMapping(value = "logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session) {
        session.removeAttribute("userBean");
        modelAndView.setViewName("/login");
        return modelAndView;
    }
}
