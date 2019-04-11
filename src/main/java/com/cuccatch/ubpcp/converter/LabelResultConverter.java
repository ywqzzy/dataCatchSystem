package com.cuccatch.ubpcp.converter;

import com.cuccatch.ubpcp.dataobject.LabelResultDO;
import com.cuccatch.ubpcp.service.model.LabelResultModel;
import org.springframework.beans.BeanUtils;

public class LabelResultConverter {
    public static LabelResultDO convertFromModel(LabelResultModel LabelResultModel) {
        if(LabelResultModel==null) return null;
        LabelResultDO LabelResultDO = new LabelResultDO();
        BeanUtils.copyProperties(LabelResultModel,LabelResultDO);
        return LabelResultDO;
    }
    public static LabelResultModel convertFromDataObject(LabelResultDO LabelResultDO) {
        if(LabelResultDO==null) return null;
        LabelResultModel LabelResultModel = new LabelResultModel();
        BeanUtils.copyProperties(LabelResultDO,LabelResultModel);
        return LabelResultModel;
    }
}
