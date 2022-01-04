package com.cdnu.baikun.enums;

/**
 * @author 白坤
 * @date 2021/7/11
 */
public enum UserStatusEnum {
    NORMAL("正常", 1), DISABLE("禁用", 0);

    private String status;
    private Integer integer;

    UserStatusEnum(String status, Integer integer) {
        this.status = status;
        this.integer = integer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
