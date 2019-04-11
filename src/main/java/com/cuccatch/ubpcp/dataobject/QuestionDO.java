package com.cuccatch.ubpcp.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class QuestionDO extends BaseEntity{
    @Column(nullable = false)
    private Integer chartID;

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
