package com.cuccatch.ubpcp.service.model;

import javax.validation.constraints.NotBlank;

public class UserModel extends BaseModel{
    @NotBlank(message = "用户名不能为空")
    private String username;
    //@Min
    //@NotNull

    @NotBlank(message = "密码不能为空")
    private String encrypt_pwd;


    private Integer browseCount;
    private Integer rateCount;
    private Integer pid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncrypt_pwd() {
        return encrypt_pwd;
    }

    public void setEncrypt_pwd(String encrypt_pwd) {
        this.encrypt_pwd = encrypt_pwd;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    public Integer getRateCount() {
        return rateCount;
    }

    public void setRateCount(Integer rateCount) {
        this.rateCount = rateCount;
    }
}
