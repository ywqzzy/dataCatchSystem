package com.cuccatch.ubpcp.service.model;

import javax.validation.constraints.NotBlank;

public class QuestionModel {

    @NotBlank(message = "表单id不能为空")
    private Integer chartID;

    @NotBlank(message = "题干不能为空")
    private String description;

    @NotBlank(message = "选项不能为空")
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
