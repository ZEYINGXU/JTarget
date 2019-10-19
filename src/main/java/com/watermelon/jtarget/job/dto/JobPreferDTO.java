package com.watermelon.jtarget.job.dto;

import java.util.Comparator;
import java.util.Date;

public class JobPreferDTO implements Comparable {

    private String jobId;

    private String jobRegion;

    private double jobSalary;

    private String jobName;

    private String jobContact;

    private String jobDetail;

    private String domain;

    private String profession;

    private Integer experienceMin;

    private Integer experienceMax;

    private String softSkills;

    private String createBy;

    private Date createDate;

    private int weights;



    @Override
    public String toString() {
        return "JobPreferDTO{" +
                "jobId='" + jobId + '\'' +
                ", jobRegion='" + jobRegion + '\'' +
                ", jobSalary=" + jobSalary +
                ", jobName='" + jobName + '\'' +
                ", jobContact='" + jobContact + '\'' +
                ", jobDetail='" + jobDetail + '\'' +
                ", domain='" + domain + '\'' +
                ", profession='" + profession + '\'' +
                ", experienceMin=" + experienceMin +
                ", experienceMax=" + experienceMax +
                ", softSkills='" + softSkills + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", weights=" + weights +
                '}';
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobRegion() {
        return jobRegion;
    }

    public void setJobRegion(String jobRegion) {
        this.jobRegion = jobRegion;
    }

    public double getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(double jobSalary) {
        this.jobSalary = jobSalary;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobContact() {
        return jobContact;
    }

    public void setJobContact(String jobContact) {
        this.jobContact = jobContact;
    }

    public String getJobDetail() {
        return jobDetail;
    }

    public void setJobDetail(String jobDetail) {
        this.jobDetail = jobDetail;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getExperienceMin() {
        return experienceMin;
    }

    public void setExperienceMin(Integer experienceMin) {
        this.experienceMin = experienceMin;
    }

    public Integer getExperienceMax() {
        return experienceMax;
    }

    public void setExperienceMax(Integer experienceMax) {
        this.experienceMax = experienceMax;
    }

    public String getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(String softSkills) {
        this.softSkills = softSkills;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getWeights() {
        return weights;
    }

    public void setWeights(int weights) {
        this.weights = weights;
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof JobPreferDTO) {
            JobPreferDTO job = (JobPreferDTO) o;
            // Descending order
            return 0 - (this.weights - job.weights);
        } else {
            return 0;
        }
    }
}
