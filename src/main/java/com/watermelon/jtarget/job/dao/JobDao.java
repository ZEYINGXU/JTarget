package com.watermelon.jtarget.job.dao;

import com.watermelon.jtarget.job.dto.JobDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDao {

    JobDTO findJob(@Param("jobId") String jobId);
}
