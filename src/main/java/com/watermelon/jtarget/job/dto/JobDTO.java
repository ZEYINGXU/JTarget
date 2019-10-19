package com.watermelon.jtarget.job.dto;

import java.util.Date;

public class JobDTO {

    private String jobId;

    private String jobRegion;

    private double jobSalary;

    private String jobName;

    private String jobContact;

    private String jobDetail;

    private String createBy;

    private Date createDate;

    @Override
    public String toString() {
        return "JobDTO{" +
                "jobId='" + jobId + '\'' +
                ", jobRegion='" + jobRegion + '\'' +
                ", jobSalary=" + jobSalary +
                ", jobName='" + jobName + '\'' +
                ", jobContact='" + jobContact + '\'' +
                ", jobDetail='" + jobDetail + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
