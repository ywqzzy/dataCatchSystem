package com.cuccatch.ubpcp.service.impl;

import com.cuccatch.ubpcp.converter.LabelResultConverter;
import com.cuccatch.ubpcp.converter.PicToLabelConverter;
import com.cuccatch.ubpcp.dao.LabelResultDao;
import com.cuccatch.ubpcp.dao.PicToLabelDao;
import com.cuccatch.ubpcp.dataobject.LabelResultDO;
import com.cuccatch.ubpcp.dataobject.PicToLabelDO;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.error.EmBusinessError;
import com.cuccatch.ubpcp.service.LabelService;
import com.cuccatch.ubpcp.service.model.LabelResultModel;
import com.cuccatch.ubpcp.service.model.PicToLabelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    PicToLabelDao picToLabelDao;
    @Autowired
    LabelResultDao labelResultDao;
    @Override
    public PicToLabelModel getPicToLabel(Integer pid) throws BusinessException {
        PicToLabelModel PicToLabelModel = null;
        PicToLabelDO PicToLabelDO = null;
        try {
            PicToLabelDO = picToLabelDao.findOneById(pid);

        }catch (Exception e) {
            throw  new BusinessException(EmBusinessError.UNKNOWN_ERROR);
        }
        if(PicToLabelDO == null) {
            throw new BusinessException(EmBusinessError.PICTOLABEL_NOT_EXIST);
        }
        return PicToLabelConverter.convertFromDataObject(PicToLabelDO);
    }

    @Override
    public void addPicToLabel(PicToLabelModel picToLabelModel) throws BusinessException {
        try {
            picToLabelDao.save(PicToLabelConverter.convertFromModel(picToLabelModel));
        } catch (Exception e) {
            throw new BusinessException(EmBusinessError.PICTOLABEL_SET_FAIL);
        }
    }

    @Override
    public void saveUserLabel(LabelResultModel labelResultModel) throws BusinessException {
        try {
            labelResultDao.save(LabelResultConverter.convertFromModel(labelResultModel));
        } catch (Exception e) {
            throw new BusinessException(EmBusinessError.USERLABEL_SET_FAIL);
        }
    }

    @Override
    public List<LabelResultModel> getLabelResultByPid(Integer pid) throws BusinessException {
        List<LabelResultDO> labelResultDOList = null;
        List<LabelResultModel> labelResultModelList = new ArrayList<>();
        try{
            labelResultDOList = labelResultDao.findByPid(pid);
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(labelResultDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.USERLABEL_NOT_EXIST);
        }
        for(LabelResultDO r:labelResultDOList) {
            labelResultModelList.add(LabelResultConverter.convertFromDataObject(r));
        }
        return labelResultModelList;
    }

    @Override
    public List<LabelResultModel> getLabelResultByUid(Integer uid) throws BusinessException {
        List<LabelResultDO> labelResultDOList = null;
        List<LabelResultModel> labelResultModelList = new ArrayList<>();
        try{
            labelResultDOList = labelResultDao.findByUid(uid);
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(labelResultDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.USERLABEL_NOT_EXIST);
        }
        for(LabelResultDO r:labelResultDOList) {
            labelResultModelList.add(LabelResultConverter.convertFromDataObject(r));
        }
        return labelResultModelList;
    }
}
