package com.cuccatch.ubpcp.response;

public enum EmReturnStatusCode {

    COMMON_SUCCESS(200),
    COMMON_FAIL(40000),
    REGISTER_FAIL(2001),
    LOGIN_FAIL(2003),
    NOT_LOGIN(100),

    ;
    private int code;
    private EmReturnStatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
