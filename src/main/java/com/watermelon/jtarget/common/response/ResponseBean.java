package com.watermelon.jtarget.common.response;

import java.io.Serializable;

/**
 * returned messages
 */
public class ResponseBean<T> implements Serializable {

    private static final long serialVersionUID = -7402216835610005310L;

    private String code;

    private String message;

    private T body;

    public ResponseBean() {
    }

    public ResponseBean(boolean flag) {
        if (flag) {
            this.code = ResponseEnum.SUCCESS.getCode();
            this.message = ResponseEnum.SUCCESS.getMessage();
        } else {
            this.code = ResponseEnum.FAILED.getCode();
            this.message = ResponseEnum.FAILED.getMessage();
        }
    }

    public ResponseBean(T body) {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.message = ResponseEnum.SUCCESS.getMessage();
        this.body = body;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public void setResponseError() {
        this.code = ResponseEnum.FAILED.getCode();
        this.message = ResponseEnum.FAILED.getMessage();
    }

    public void setResponseError(String message) {
        this.code = ResponseEnum.FAILED.getCode();
        this.message = message;
    }

    public void setResponseError(String message, T body) {
        this.code = ResponseEnum.FAILED.getCode();
        this.message = message;
        this.body = body;
    }

    public void setResponseSuccess() {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.message = ResponseEnum.SUCCESS.getMessage();
    }

    public void setResponseSuccess(String message) {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.message = message;
    }

    public void setResponseSuccess(T body) {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.message = ResponseEnum.SUCCESS.getMessage();
        this.body = body;
    }
}
