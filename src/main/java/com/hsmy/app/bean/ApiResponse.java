package com.hsmy.app.bean;

public class ApiResponse {
    String code;
    String msg;
    Data data;
    String checkNum;

    public String getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public com.hsmy.app.bean.Data getApiData() {
        return data;
    }

    public void setApiData(com.hsmy.app.bean.Data apiData) {
        this.data = apiData;
    }
}
