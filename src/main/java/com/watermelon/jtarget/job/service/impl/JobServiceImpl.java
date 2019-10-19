package com.watermelon.jtarget.job.service.impl;

import com.watermelon.jtarget.common.pager.PageInfo;
import com.watermelon.jtarget.common.util.UUIDUtils;
import com.watermelon.jtarget.job.dao.JobDao;
import com.watermelon.jtarget.job.dto.JobDTO;
import com.watermelon.jtarget.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public PageInfo findJobs(Integer currentPage, Integer pageSize, String key) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(currentPage);
        pageInfo.setPageSize(pageSize);
        int totalCount = jobDao.findJobCount(key);
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        pageInfo.setTotalPage(totalPage);
        pageInfo.setData(jobDao.findJobs((currentPage - 1) * pageSize, pageSize, key));
        pageInfo.setFirstPage(currentPage == 1);
        pageInfo.setLastPage(currentPage == pageInfo.getTotalPage());
        return pageInfo;
    }


}
