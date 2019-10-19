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

    int findJobUsePreferCount(@Param("prefer") String prefer);

    List<JobDTO> findJobsUsePrefer(@Param("fromIndex") Integer fromIndex,
                                   @Param("pageSize") Integer pageSize,
                                   @Param("prefer") String prefer);

    int findJobCount(@Param("jobName") String jobName,
                     @Param("jobRegion") String jobRegion,
                     @Param("jobSalary") String jobSalary);

    List<JobDTO> findJobs(@Param("fromIndex") Integer fromIndex,
                          @Param("pageSize") Integer pageSize,
                          @Param("jobName") String jobName,
                          @Param("jobRegion") String jobRegion,
                          @Param("jobSalary") String jobSalary);
}
