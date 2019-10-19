package com.watermelon.jtarget.job.service.impl;

import com.watermelon.jtarget.common.pager.PageInfo;
import com.watermelon.jtarget.common.util.UUIDUtils;
import com.watermelon.jtarget.job.dao.JobDao;
import com.watermelon.jtarget.job.dto.JobDTO;
import com.watermelon.jtarget.job.dto.JobPreferDTO;
import com.watermelon.jtarget.job.service.JobService;
import com.watermelon.jtarget.user.vo.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;


@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private UUIDUtils uuidUtils;

    @Autowired
    private JobDao jobDao;

    @Override
    public JobDTO findJob(String jobId) {
        return jobDao.findJob(jobId);
    }

    @Override
    public boolean addJob(JobDTO job) {
        job.setJobId(uuidUtils.generate());
        int result = jobDao.addJob(job);
        return result > 0;
    }

    @Override
    public boolean updateJob(JobDTO job) {
        JobDTO jobExist = findJob(job.getJobId());
        if (jobExist == null) {
            return false;
        }
        int result = jobDao.updateJob(job);
        return result > 0;
    }

    @Override
    public PageInfo findJobs(Integer currentPage, Integer pageSize, String jobName, String jobRegion, String jobSalary) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        int totalCount = jobDao.findJobCount(jobName, jobRegion, jobSalary);
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pageInfo.setTotalPage(totalPage);
        pageInfo.setData(jobDao.findJobs((currentPage - 1) * pageSize, pageSize, jobName, jobRegion, jobSalary));
        pageInfo.setFirstPage(currentPage == 1);
        pageInfo.setLastPage(currentPage == pageInfo.getTotalPage());
        return pageInfo;
    }

    @Override
    public PageInfo findJobs(Integer currentPage, Integer pageSize, UserBean userBean, String key) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        List<JobPreferDTO> jobs = jobDao.findAllJobs(key);

        for (JobPreferDTO job : jobs) {
            int domain_weight = 10;
            int profession_weight = 100;
            int experience_weight = 2;
            int weight = 0;
            if (!StringUtils.isEmpty(userBean.getDomain())
                    && userBean.getDomain().contains(job.getDomain())) {
                weight = weight + domain_weight;
            }
            if (!StringUtils.isEmpty(userBean.getProfession())
                    && userBean.getProfession().contains(job.getProfession())) {
                weight = weight + profession_weight;
            }
            if (job.getExperienceMin() <= userBean.getExperience()
                    && job.getExperienceMax() >= userBean.getExperience()) {
                weight = userBean.getExperience() + weight;
            }
            job.setWeights(weight);
        }
        Collections.sort(jobs);

        int totalCount = jobs.size();
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pageInfo.setTotalPage(totalPage);
        int start = (currentPage - 1) * pageSize;
        int end = start + pageSize;
        pageInfo.setData(jobs.subList(start, end > jobs.size() ? jobs.size() : end));
        pageInfo.setFirstPage(currentPage == 1);
        pageInfo.setLastPage(currentPage == pageInfo.getTotalPage());
        return pageInfo;
    }


}
