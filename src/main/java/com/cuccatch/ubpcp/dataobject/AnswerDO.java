package com.cuccatch.ubpcp.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "answer")
public class AnswerDO extends BaseEntity{
    @Column(nullable = false)
    private Integer chartID;

    @Column(nullable = false)
    private Integer uID;

    @Column(nullable = false)
    private Integer qID;

    @Column(length = 128, nullable = false)
    private String description;

    @Column(length = 1000, nullable = false)
    private String options;

    public Integer getChartID() {
        return chartID;
    }

    public void setChartID(Integer chartID) {
        this.chartID = chartID;
    }

    public Integer getuID() {
        return uID;
    }

    public void setuID(Integer uID) {
        this.uID = uID;
    }

    public Integer getqID() {
        return qID;
    }

    public void setqID(Integer qID) {
        this.qID = qID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
