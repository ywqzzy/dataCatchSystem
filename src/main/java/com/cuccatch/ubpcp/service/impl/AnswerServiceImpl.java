package com.cuccatch.ubpcp.service.impl;

import com.cuccatch.ubpcp.converter.AnswerConverter;
import com.cuccatch.ubpcp.dao.AnswerDao;
import com.cuccatch.ubpcp.dataobject.AnswerDO;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.error.EmBusinessError;
import com.cuccatch.ubpcp.service.AnswerService;
import com.cuccatch.ubpcp.service.model.AnswerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerDao answerDao;
    @Override
    public void saveAnswer(AnswerModel answerModel) throws BusinessException {
        AnswerDO answerDO = AnswerConverter.convertFromModel(answerModel);
        try{
            answerDao.save(answerDO);
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.UNKNOWN_ERROR);
        }
    }

    @Override
    public void saveAnswers(List<AnswerModel> answerModels) throws BusinessException {
        try{
            for(AnswerModel m: answerModels) {
                answerDao.save(AnswerConverter.convertFromModel(m));
            }
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.UNKNOWN_ERROR);
        }
    }

    @Override
    public List<AnswerModel> getAnswersByUID(Integer uid) throws BusinessException {
        List<AnswerModel> answerModelList = new ArrayList<>();
        List<AnswerDO> answerDOList;
        try {
            answerDOList = answerDao.findByUID(uid);
        }catch(Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(answerDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.ANSWER_NOT_EXIST);
        }
        for(AnswerDO a: answerDOList) {
            answerModelList.add(AnswerConverter.convertFromDataObject(a));
        }
        return answerModelList;
    }

    @Override
    public List<AnswerModel> getAnswersByChartID(Integer chartId) throws BusinessException {
        List<AnswerModel> answerModelList = new ArrayList<>();
        List<AnswerDO> answerDOList;
        try {
            answerDOList = answerDao.findByChartID(chartId);
        }catch(Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(answerDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.ANSWER_NOT_EXIST);
        }
        for(AnswerDO a: answerDOList) {
            answerModelList.add(AnswerConverter.convertFromDataObject(a));
        }
        return answerModelList;
    }
}
