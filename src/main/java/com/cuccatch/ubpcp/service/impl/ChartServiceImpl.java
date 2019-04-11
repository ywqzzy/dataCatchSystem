package com.cuccatch.ubpcp.service.impl;

import com.cuccatch.ubpcp.converter.ChartConverter;
import com.cuccatch.ubpcp.converter.QuestionConverter;
import com.cuccatch.ubpcp.converter.RateConverter;
import com.cuccatch.ubpcp.dao.ChartDao;
import com.cuccatch.ubpcp.dao.QuestionDao;
import com.cuccatch.ubpcp.dataobject.ChartDO;
import com.cuccatch.ubpcp.dataobject.QuestionDO;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.error.EmBusinessError;
import com.cuccatch.ubpcp.service.ChartService;
import com.cuccatch.ubpcp.service.model.ChartModel;
import com.cuccatch.ubpcp.service.model.QuestionModel;
import javafx.scene.chart.Chart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChartServiceImpl implements ChartService {


    @Autowired
    ChartDao chartDao;

    @Autowired
    QuestionDao questionDao;
    @Override
    public void saveChart(ChartModel chartModel, List<QuestionModel> questionModelList) throws BusinessException {
        if(chartModel == null || questionModelList == null || questionModelList.isEmpty()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        // list chartid赋值
        ChartDO chartDO = ChartConverter.convertFromModel(chartModel);
        try {
            chartDao.save(chartDO);
        }catch (Exception e) {
            throw  new BusinessException((EmBusinessError.CHART_SET_FAIL));
        }
        try {
            for (QuestionModel q : questionModelList) {
                q.setChartID(chartDO.getId());
                questionDao.save(QuestionConverter.convertFromModel(q));
            }
        }
        catch (Exception e) {
                throw  new BusinessException((EmBusinessError.CHART_SET_FAIL));
        }
    }

    @Override
    public List<ChartDO> getAllChart() throws BusinessException {
        List<ChartDO> chartDOList = new ArrayList<>();
        try {
            chartDOList = chartDao.findAll();
        }catch (Exception e) {
            throw  new BusinessException(EmBusinessError.UNKNOWN_ERROR);
        }
        if(chartDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.CHARTS_NOT_EXIST);
        }
        return chartDOList;
    }

    @Override
    public Page<ChartDO> getChartByPage(Integer page, Integer size) throws BusinessException {
        PageRequest pageable = PageRequest.of(page-1, size, Sort.Direction.DESC, "id");
        try{
            return chartDao.findAll(pageable);
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.CHARTS_NOT_EXIST);
        }
    }

    @Override
    public List<QuestionModel> getQuestionsByChartId(Integer chartId) throws BusinessException {
        List<QuestionDO> questionDOList = null;
        List<QuestionModel> questionModelList = new ArrayList<>();
        try{
            questionDOList = questionDao.findByChartID(chartId);
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(questionDOList.isEmpty()) {
            throw  new BusinessException(EmBusinessError.QUESTION_NOT_EXIST);
        }
        for(QuestionDO Q: questionDOList) {
            questionModelList.add(QuestionConverter.convertFromDataObject(Q));
        }
        return questionModelList;
    }
}
