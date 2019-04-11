package com.cuccatch.ubpcp.service.model;

public class LabelResultModel {
    private Integer uid;
    // qid 代表是哪一个图
    private Integer pid;

    private String label;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
