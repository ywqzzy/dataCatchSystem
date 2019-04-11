package com.cuccatch.ubpcp.error;

public enum EmBusinessError implements CommonError{
    //通用错误类型
    DATABASE_ERROR(10000,"数据库操作失败"),
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),
    USER_NOT_EXIST(20001,"用户不存在"),
    USER_EXIST(20003,"用户已存在"),
    RATE_SET_FAIL(20010,"评分设置失败"),
    RATE_NOT_EXIST(20011,"评分不存在"),
    CHART_SET_FAIL(20012,"问卷设置失败"),
    CHARTS_NOT_EXIST(20013,"无问卷"),
    QUESTION_NOT_EXIST(20014,"问卷无问题"),
    ANSWER_NOT_EXIST(20015,"用户无回答"),
    MOVIE_NOT_EXIST(20016,"电影不存在"),
    USERBROWSE_SET_FAIL(20017,"埋点失败"),
    USERBROWSE_NOT_EXIST(20018,"浏览记录不存在"),
    PICTOLABEL_SET_FAIL(20019,"添加待标注图片失败"),
    PICTOLABEL_NOT_EXIST(20020,"待标注图片不存在"),
    USERLABEL_SET_FAIL(20021,"用户标注失败"),
    USERLABEL_NOT_EXIST(20021,"用户标注不存在"),
    USER_LOGIN_FAIL(20004,"用户手机号或密码不正确"),
    TOKEN_SET_FAIL(20005,"Token设置失败"),
    TOKEN_NOT_EXIST(20006,"Token不存在"),
    TOKEN_WRONG(20007,"Token错误"),
    WITHOUT_TOKEN(20008,"缺少授权参数"),
    NOT_LOGIN(20009,"未登录"),
    PROJECT_NOT_EXIST(30001,"项目不存在"),
    PROJECT_UPLOAD_FAIL(30002,"项目上传失败"),
    ;

    private EmBusinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
    private int errCode;
    private String errMsg;
    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
