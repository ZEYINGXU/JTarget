package com.watermelon.jtarget.job.service.impl;

import com.watermelon.jtarget.common.exception.BizException;
import com.watermelon.jtarget.job.dao.JobDao;
import com.watermelon.jtarget.job.dto.JobDTO;
import com.watermelon.jtarget.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;

    @Override
    public JobDTO findJob(String jobId) {
        if (StringUtils.isEmpty(jobId)) {
            throw new BizException("job id is empty!");
        }
        return jobDao.findJob(jobId);
    }
}
