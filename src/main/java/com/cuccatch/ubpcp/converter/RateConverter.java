package com.cuccatch.ubpcp.converter;

import com.cuccatch.ubpcp.dataobject.RateDO;
import com.cuccatch.ubpcp.service.model.RateModel;
import org.springframework.beans.BeanUtils;

public class RateConverter {
    public static RateDO convertFromModel(RateModel rateModel) {
        if(rateModel==null) return null;
        RateDO rateDO = new RateDO();
        BeanUtils.copyProperties(rateModel,rateDO);
        return rateDO;
    }

    public static RateModel convertFromDataObject(RateDO rateDO) {
        if(rateDO==null) return null;
        RateModel rateModel = new RateModel();
        BeanUtils.copyProperties(rateDO,rateModel);
        return rateModel;
    }
}
