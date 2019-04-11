package com.cuccatch.ubpcp.service;

import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.service.model.LabelResultModel;
import com.cuccatch.ubpcp.service.model.PicToLabelModel;

import java.util.List;

public interface LabelService {
    PicToLabelModel getPicToLabel(Integer pid) throws BusinessException;
    void addPicToLabel(PicToLabelModel picToLabelModel) throws BusinessException;
    void saveUserLabel(LabelResultModel labelResultModel) throws BusinessException;
    List<LabelResultModel> getLabelResultByPid(Integer pid) throws BusinessException;
    List<LabelResultModel> getLabelResultByUid(Integer uid) throws BusinessException;
}
