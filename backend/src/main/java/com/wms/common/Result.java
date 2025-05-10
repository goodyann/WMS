package com.wms.common;

import lombok.Data;

@Data
public class Result {
    private int code; // 200/400
    private String msg; // succeed/fail
    private Long total; // total records
    private Object data; // data

    // I don't know why I use lombok, it still requires me to write setter
    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public Long getTotal() {
        return total;
    }

    public Object getData() {
        return data;
    }

    // fail
    public static Result fail() {
        return result(400, "fail", 0L, null);
    }

    // success
    public static Result suc() {
        return result(200, "success", 0L, null);
    }

    // success
    public static Result suc(Object data) {
        return result(200, "success", 0L, data);
    }

    // success
    public static Result suc(Long total, Object data) {
        return result(200, "success", total, data);
    }



    private static Result result(int code, String msg, Long total, Object data) {
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        res.setTotal(total);
        res.setData(data);
        return res;
    }
}
