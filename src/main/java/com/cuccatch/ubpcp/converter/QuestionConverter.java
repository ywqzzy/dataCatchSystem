package com.cuccatch.ubpcp.converter;

import com.cuccatch.ubpcp.dataobject.QuestionDO;
import com.cuccatch.ubpcp.dataobject.QuestionDO;
import com.cuccatch.ubpcp.service.model.QuestionModel;
import com.cuccatch.ubpcp.service.model.QuestionModel;
import org.springframework.beans.BeanUtils;

public class QuestionConverter {
    public static QuestionDO convertFromModel(QuestionModel questionModel) {
        if(questionModel==null) return null;
        QuestionDO questionDO = new QuestionDO();
        BeanUtils.copyProperties(questionModel,questionDO);
        return questionDO;
    }

    public static QuestionModel convertFromDataObject(QuestionDO QuestionDO) {
        if(QuestionDO==null) return null;
        QuestionModel QuestionModel = new QuestionModel();
        BeanUtils.copyProperties(QuestionDO,QuestionModel);
        return QuestionModel;
    }
}
