package com.cuccatch.ubpcp.dataobject;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserDO extends BaseEntity{
    @Column(name = "username",length = 64, nullable = false)
    private String username;
    @Column(name="encrypt_pwd",length = 128,nullable = false)
    private String encryptPwd;


    @Column(nullable = false,columnDefinition="INT default 0")
    private Integer browseCount;
    @Column(nullable = false,columnDefinition = "INT default 0")
    private Integer rateCount;


    @Column(nullable = false,columnDefinition = "INT default 1")
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

    public String getEncryptPwd() {
        return encryptPwd;
    }

    public void setEncryptPwd(String encryptPwd) {
        this.encryptPwd = encryptPwd;
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
