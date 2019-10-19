package com.watermelon.jtarget.job.dao;

import com.watermelon.jtarget.job.dto.JobDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDao {

    JobDTO findJob(@Param("jobId") String jobId);

    int addJob(JobDTO job);

    int updateJob(JobDTO job);

    int deleteJob(@Param("jobId") String jobId);

    int findJobCount(@Param("key") String key);

    List<JobDTO> findJobs(@Param("fromIndex") Integer fromIndex,
                          @Param("pageSize") Integer pageSize,
                          @Param("key") String key);
}
