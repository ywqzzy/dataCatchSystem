package com.cuccatch.ubpcp.dataobject;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Rate")
public class RateDO extends BaseEntity{

    @Column(nullable = false)
    private Integer uid;

    @Column(length = 64, nullable = false)
    private String movieName;

    @Column(nullable = false,columnDefinition = "tinyint default 0")
    private Integer rate;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
