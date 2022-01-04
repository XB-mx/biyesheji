package com.cdnu.baikun.enums;

public enum UserRoleEnum {
    ADMIN("admin", 0), USER("user", 1), VIP("vip", 2);
    private String role;
    private Integer integer;

    UserRoleEnum(String role, Integer integer) {
        this.role = role;
        this.integer = integer;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
