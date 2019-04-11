package com.cuccatch.ubpcp.error;

// 包装器模式 业务异常类实现
// 何时使用 service和 controller中的边界条件时！！！！
public class BusinessException extends Exception implements CommonError{

    private CommonError commonError;

    // 直接接受EmBusinessError 用于构造业务异常
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }
    // 接受自定义errMsg 构造业务异常
    public BusinessException(CommonError commonError, String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }
    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
