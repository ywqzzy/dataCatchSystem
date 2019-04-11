package com.cuccatch.ubpcp.dataobject;

import javax.persistence.*;

@Entity
@Table(name = "token")
public class TokenDO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private long expired;
    @Column(nullable = false,columnDefinition = "tinyint default 0")
    private byte status;// 0有效，1无效
    @Column(nullable = false)
    private int userid;
    @Column(nullable = false,length = 64)
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getExpired() {
        return expired;
    }

    public void setExpired(long expired) {
        this.expired = expired;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
