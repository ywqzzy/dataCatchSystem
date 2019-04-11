package com.cuccatch.ubpcp.dataobject;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "userbrowse")
public class UserBrowseDO extends BaseEntity {

    @Column(nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private Integer movieId;

    @CreatedDate
    @Column(nullable = false)
    private Long ctime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }
}
