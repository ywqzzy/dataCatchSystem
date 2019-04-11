package com.cuccatch.ubpcp.service;

import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.service.model.AnswerModel;

import java.util.List;

public interface AnswerService {
    void saveAnswer(AnswerModel answerModel) throws BusinessException;
    void saveAnswers(List<AnswerModel> answerModels) throws BusinessException;
    List<AnswerModel>  getAnswersByUID(Integer uid) throws BusinessException;
    List<AnswerModel>  getAnswersByChartID(Integer chartId) throws BusinessException;
}
