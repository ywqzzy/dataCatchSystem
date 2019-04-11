package com.cuccatch.ubpcp.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "pic_to_label")
public class PicToLabelDO extends BaseEntity {
    @Column(length = 100, nullable = false)
    private String img_url;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
