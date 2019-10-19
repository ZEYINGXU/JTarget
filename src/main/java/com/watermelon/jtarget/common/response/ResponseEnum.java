package com.watermelon.jtarget.common.response;

/**
 * returned messages
 */
public enum ResponseEnum {

    SUCCESS("000000", "操作成功"),
    FAILED("999999", "操作失败");

    private String code;

    private String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
