package com.cuccatch.ubpcp.converter;

import com.cuccatch.ubpcp.service.model.HistoryModel;
import com.cuccatch.ubpcp.service.model.MovieModel;
import org.springframework.beans.BeanUtils;

public class HistoryConverter {
    public static HistoryModel convertFromMovie(MovieModel movieModel) {
        if(movieModel==null) return null;
        HistoryModel historyModel = new HistoryModel();
        BeanUtils.copyProperties(movieModel,historyModel);
        return historyModel;
    }
}
