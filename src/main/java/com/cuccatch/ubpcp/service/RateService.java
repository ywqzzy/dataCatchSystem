package com.cuccatch.ubpcp.service;

import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.service.model.RateModel;

import java.util.List;

public interface RateService {
    void setRate(RateModel rateModel) throws BusinessException;
    boolean checkRate(Integer uid,String movieName);
    List<RateModel> getRate(Integer uid, String movieName) throws BusinessException;
    List<RateModel> getRateByUid(Integer uid) throws BusinessException;
    List<RateModel> getRateByMovieName(String movieName) throws BusinessException;
}
