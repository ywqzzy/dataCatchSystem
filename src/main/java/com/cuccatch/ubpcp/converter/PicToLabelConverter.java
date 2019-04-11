package com.cuccatch.ubpcp.converter;

import com.cuccatch.ubpcp.dataobject.PicToLabelDO;
import com.cuccatch.ubpcp.service.model.PicToLabelModel;
import com.zaxxer.hikari.util.PropertyElf;
import org.springframework.beans.BeanUtils;

public class PicToLabelConverter {
    public static PicToLabelDO convertFromModel(PicToLabelModel PicToLabelModel) {
        if(PicToLabelModel==null) return null;
        PicToLabelDO PicToLabelDO = new PicToLabelDO();
        BeanUtils.copyProperties(PicToLabelModel,PicToLabelDO);
        return PicToLabelDO;
    }
    public static PicToLabelModel convertFromDataObject(PicToLabelDO PicToLabelDO) {
        if(PicToLabelDO==null) return null;
        PicToLabelModel PicToLabelModel = new PicToLabelModel();
        BeanUtils.copyProperties(PicToLabelDO,PicToLabelModel);
        return PicToLabelModel;
    }
}
