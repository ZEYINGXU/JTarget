package com.watermelon.jtarget.user.vo;

import java.io.Serializable;

public class UserBean implements Serializable {

    private static final long serialVersionUID = -1203754670613112562L;

    private String userId;

    private String userAccount;

    private String userName;

    private String userType;

    private String domain;

    private String profession;

    private int experience;

    private String softSkills;

    private String token;

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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(String softSkills) {
        this.softSkills = softSkills;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userId='" + userId + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                ", domain='" + domain + '\'' +
                ", profession='" + profession + '\'' +
                ", experience=" + experience +
                ", softSkills='" + softSkills + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
