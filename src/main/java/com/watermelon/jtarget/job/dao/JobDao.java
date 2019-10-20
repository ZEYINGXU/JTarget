package com.watermelon.jtarget.job.dao;

import com.watermelon.jtarget.job.dto.JobDTO;
import com.watermelon.jtarget.job.dto.JobPreferDTO;
import com.watermelon.jtarget.user.dto.UserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDao {

    JobDTO findJob(@Param("jobId") String jobId);

    int addJob(JobDTO job);

    int updateJob(JobDTO job);

    int deleteJob(@Param("jobId") String jobId);

    int findJobCount(@Param("jobName") String jobName,
                     @Param("jobRegion") String jobRegion,
                     @Param("jobSalary") String jobSalary);

    List<JobDTO> findJobs(@Param("fromIndex") Integer fromIndex,
                          @Param("pageSize") Integer pageSize,
                          @Param("jobName") String jobName,
                          @Param("jobRegion") String jobRegion,
                          @Param("jobSalary") String jobSalary);

    List<JobPreferDTO> findAllJobs(@Param("key") String key);

    int insertJobApply(@Param("applyId") String applyId,
                       @Param("jobId") String jobId,
                       @Param("userId") String userId);

    int findApplyCount(@Param("jobId") String jobId);

    int findApplicantCount(@Param("jobId") String jobId, @Param("key") String key);

    List<UserDTO> findApplicant(
                                @Param("jobId") String jobId,
                                @Param("key") String key);
}
