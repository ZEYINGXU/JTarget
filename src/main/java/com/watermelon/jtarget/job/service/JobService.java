package com.watermelon.jtarget.job.service;

import com.watermelon.jtarget.common.pager.PageInfo;
import com.watermelon.jtarget.job.dto.JobDTO;
import com.watermelon.jtarget.user.vo.UserBean;


public interface JobService {

    JobDTO findJob(String jobId);

    boolean addJob(JobDTO job);

    boolean updateJob(JobDTO job);

    PageInfo findJobs(Integer currentPage, Integer pageSize,
                      String jobName, String jobRegion, String jobSalary);


    PageInfo findJobs(Integer currentPage, Integer pageSize, UserBean userBean, String key);

    boolean applyJob(String jobId, String userId);
}
