package com.cuccatch.ubpcp.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "chart")
public class ChartDO extends BaseEntity{


    @Column(length = 128, nullable = false)
    private String title;

    @Column(length = 128, nullable = false)
    private String direction;

    @Column(nullable = false)
    private Integer createUserId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }
}
