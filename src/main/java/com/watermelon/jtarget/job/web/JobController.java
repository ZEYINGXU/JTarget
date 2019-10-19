package com.watermelon.jtarget.job.web;

import com.watermelon.jtarget.common.pager.PageInfo;
import com.watermelon.jtarget.common.response.ResponseBean;
import com.watermelon.jtarget.job.dto.JobDTO;
import com.watermelon.jtarget.job.service.JobService;
import com.watermelon.jtarget.user.vo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/job")
public class JobController {

    private String errorMessage = "Parameter error";

    @Autowired
    private JobService jobService;

    @GetMapping(value = "/addJob")
    public ModelAndView addJobView(ModelAndView modelAndView) {
        modelAndView.setViewName("jobadd");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addJob(@RequestParam Map<String, String> param, ModelAndView modelAndView, HttpSession session) {
        JobDTO job = new JobDTO();
        job.setJobName(param.get("name"));
        job.setJobRegion(param.get("region"));
        String salary = param.get("salary");
        if (StringUtils.isEmpty(salary)) {
            job.setJobSalary(0);
        } else {
            job.setJobSalary(Double.valueOf(param.get("salary")));
        }
        job.setJobContact(param.get("contact"));
        job.setJobDetail(param.get("detail"));

        UserBean userBean = (UserBean) session.getAttribute("userBean");
        job.setCreateBy(userBean.getUserId());

        jobService.addJob(job);

        PageInfo pageInfo = jobService.findJobs(1, 10, null);

        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("pageNum", pageInfo.getCurrentPage());
        modelAndView.addObject("pageSize", pageInfo.getPageSize());
        modelAndView.addObject("isFirstPage", pageInfo.isFirstPage());
        modelAndView.addObject("totalPages", pageInfo.getTotalPage());
        modelAndView.addObject("isLastPage", pageInfo.isLastPage());

        modelAndView.setViewName("jobs");
        return modelAndView;
    }

    @GetMapping(value = "/detail")
    public ModelAndView findJobDetails(@RequestParam String jobId, ModelAndView modelAndView, HttpSession session) {
        Object userBeanObj = session.getAttribute("userBean");
        if (userBeanObj == null) {
            modelAndView.setViewName("login");
            return modelAndView;
        }
        UserBean userBean = (UserBean) userBeanObj;

        if (StringUtils.isEmpty(jobId)) {
            modelAndView.addObject("error", errorMessage);
            modelAndView.setViewName("jobs");
            return modelAndView;
        }
        JobDTO job = jobService.findJob(jobId);
        modelAndView.addObject("job", job);
        modelAndView.addObject("userBean", userBean);
        modelAndView.setViewName("job");
        return modelAndView;
    }

    @GetMapping(value = "/list")
    public ModelAndView findJobs(@RequestParam(required = false) Integer currentPage,
                                 @RequestParam(required = false) Integer pageSize,
                                 @RequestParam(required = false) String key,
                                 ModelAndView modelAndView) {

        if (currentPage == null || currentPage < 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize < 0) {
            pageSize = 10;
        }
        PageInfo pageInfo = jobService.findJobs(currentPage, pageSize, key);

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
