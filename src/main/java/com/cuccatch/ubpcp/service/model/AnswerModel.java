package com.cuccatch.ubpcp.service.model;

public class AnswerModel {
    private Integer chartID;

    private Integer UID;

    private Integer QID;

    private String description;

    private String options;

    public Integer getChartID() {
        return chartID;
    }

    public void setChartID(Integer chartID) {
        this.chartID = chartID;
    }

    public Integer getUID() {
        return UID;
    }

    public void setUID(Integer UID) {
        this.UID = UID;
    }

    public Integer getQID() {
        return QID;
    }

    public void setQID(Integer QID) {
        this.QID = QID;
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
