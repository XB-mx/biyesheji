package com.cdnu.baikun.dto;


public class ResultVO {
    private String msg;
    private Integer status;
    private Integer code;
    private Integer count;
    private Object data;

    public ResultVO(String msg, Integer status,Object data) {
        this.msg = msg;
        this.status = status;
        this.data=data;
    }

    public ResultVO(String msg, Integer status) {
        this.msg = msg;
        this.status = status;
    }

    public ResultVO(String msg,Integer code,Integer count, Object data) {
        this.code=code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
