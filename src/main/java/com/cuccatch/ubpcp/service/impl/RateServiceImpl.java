package com.cuccatch.ubpcp.service.impl;

import com.cuccatch.ubpcp.converter.RateConverter;
import com.cuccatch.ubpcp.dao.RateDao;
import com.cuccatch.ubpcp.dataobject.RateDO;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.error.EmBusinessError;
import com.cuccatch.ubpcp.service.RateService;
import com.cuccatch.ubpcp.service.model.RateModel;
import com.cuccatch.ubpcp.validator.ValidationResult;
import com.cuccatch.ubpcp.validator.ValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RateServiceImpl implements RateService {

    @Autowired
    RateDao rateDao;

    @Override
    public void setRate(RateModel rateModel) throws BusinessException {
        try {
           rateDao.save(RateConverter.convertFromModel(rateModel));
        } catch (Exception e) {
            throw new BusinessException(EmBusinessError.RATE_SET_FAIL);
        }
    }

    @Override
    public boolean checkRate(Integer uid, String movieName) {
        List<RateDO> rateModelList = rateDao.findByUidAndMovieName(uid,movieName);
        if(rateModelList.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public List<RateModel> getRate(Integer uid, String movieName) throws BusinessException {
        List<RateDO> rateDOList = null;
        List<RateModel> rateModelList = new ArrayList<>();
        try{
            rateDOList = rateDao.findByUidAndMovieName(uid,movieName);
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(rateDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.RATE_NOT_EXIST);
        }
        for(RateDO r:rateDOList) {
            rateModelList.add(RateConverter.convertFromDataObject(r));
        }
        return rateModelList;
    }

    @Override
    public List<RateModel> getRateByUid(Integer uid) throws BusinessException {
        List<RateDO> rateDOList = null;
        List<RateModel> rateModelList = new ArrayList<>();
        try{
            rateDOList = rateDao.findByUid(uid);
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(rateDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.RATE_NOT_EXIST);
        }
        for(RateDO r:rateDOList) {
            rateModelList.add(RateConverter.convertFromDataObject(r));
        }
        return rateModelList;
    }

    @Override
    public List<RateModel> getRateByMovieName(String movieName) throws BusinessException {
        List<RateDO> rateDOList = null;
        List<RateModel> rateModelList = new ArrayList<>();
        try{
            rateDOList = rateDao.findByMovieName(movieName);
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(rateDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.RATE_NOT_EXIST);
        }
        for(RateDO r:rateDOList) {
            rateModelList.add(RateConverter.convertFromDataObject(r));
        }
        return rateModelList;
    }


}
