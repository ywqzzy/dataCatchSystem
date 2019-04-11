package com.cuccatch.ubpcp.service.model;

import javax.validation.constraints.NotBlank;

public class RateModel {

    @NotBlank(message = "用户id不能为空")
    private Integer uid;
    @NotBlank(message = "评分不能为空")
    private Integer rate;
    @NotBlank(message = "电影名不能为空")
    private String movieName;

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
