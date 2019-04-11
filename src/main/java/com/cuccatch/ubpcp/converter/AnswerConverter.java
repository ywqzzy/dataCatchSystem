package com.cuccatch.ubpcp.converter;

import com.cuccatch.ubpcp.dataobject.AnswerDO;
import com.cuccatch.ubpcp.service.model.AnswerModel;
import org.springframework.beans.BeanUtils;

public class AnswerConverter {

    public static AnswerDO convertFromModel(AnswerModel AnswerModel) {
        if(AnswerModel==null) return null;
        AnswerDO AnswerDO = new AnswerDO();
        BeanUtils.copyProperties(AnswerModel,AnswerDO);
        return AnswerDO;
    }

    public static AnswerModel convertFromDataObject(AnswerDO AnswerDO) {
        if(AnswerDO==null) return null;
        AnswerModel AnswerModel = new AnswerModel();
        BeanUtils.copyProperties(AnswerDO,AnswerModel);
        return AnswerModel;
    }
}
