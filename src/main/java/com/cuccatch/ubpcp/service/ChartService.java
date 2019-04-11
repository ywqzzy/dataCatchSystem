package com.cuccatch.ubpcp.service;

import com.cuccatch.ubpcp.dataobject.ChartDO;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.service.model.ChartModel;
import com.cuccatch.ubpcp.service.model.QuestionModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ChartService {
    void saveChart(ChartModel chartModel, List<QuestionModel> questionModelList) throws BusinessException;
    List<ChartDO> getAllChart() throws BusinessException;
    Page<ChartDO> getChartByPage(Integer page, Integer size) throws BusinessException;
    List<QuestionModel> getQuestionsByChartId(Integer chartId) throws BusinessException;
}
