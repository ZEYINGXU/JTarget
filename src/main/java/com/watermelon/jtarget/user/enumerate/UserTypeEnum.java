package com.watermelon.jtarget.user.enumerate;

public enum UserTypeEnum {
    JOB_SEEKER("1"),
    RECRUITER("2"),
    SYS_ADMIN("3");
    private String type;

    UserTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
