package com.cuccatch.ubpcp.converter;

import com.cuccatch.ubpcp.dataobject.ChartDO;

import com.cuccatch.ubpcp.service.model.ChartModel;

import org.springframework.beans.BeanUtils;

public class ChartConverter {
    public static ChartDO convertFromModel(ChartModel chartModel) {
        if(chartModel==null) return null;
        ChartDO chartDO = new ChartDO();
        BeanUtils.copyProperties(chartModel,chartDO);
        return chartDO;
    }

    public static ChartModel convertFromDataObject(ChartDO chartDO) {
        if(chartDO==null) return null;
        ChartModel chartModel = new ChartModel();
        BeanUtils.copyProperties(chartDO,chartModel);
        return chartModel;
    }
}
