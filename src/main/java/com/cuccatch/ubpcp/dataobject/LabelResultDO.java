package com.cuccatch.ubpcp.dataobject;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "label_result")
public class LabelResultDO extends BaseEntity{
    @Column(nullable = false)
    private Integer uid;
    // qid 代表是哪一个图
    @Column(nullable = false)
    private Integer pid;
    @Column(length = 128, nullable = false)
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
