package com.cuccatch.ubpcp.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonReturnType {

    private String msg;
    private int statusCode;
    private Object data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static CommonReturnType create(Object res) {
        return CommonReturnType.create(res,"success",EmReturnStatusCode.COMMON_SUCCESS);
    }
    public static CommonReturnType createPlainText(String msg,EmReturnStatusCode code) {
        return CommonReturnType.create(null,msg,code);
    }

    public static CommonReturnType createSuccess(Object res,String msg) {
        return CommonReturnType.create(res,msg,EmReturnStatusCode.COMMON_SUCCESS);
    }

    public static CommonReturnType create(Object res,String msg,EmReturnStatusCode code) {
        CommonReturnType type = new CommonReturnType();
        type.setData(res);
        type.setMsg(msg);
        type.setStatusCode(code.getCode());
        return type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
