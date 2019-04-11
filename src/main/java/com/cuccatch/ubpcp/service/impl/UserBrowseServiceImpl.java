package com.cuccatch.ubpcp.service.impl;

import com.cuccatch.ubpcp.converter.HistoryConverter;
import com.cuccatch.ubpcp.converter.UserBrowseConverter;
import com.cuccatch.ubpcp.dao.UserBrowseDao;
import com.cuccatch.ubpcp.dataobject.UserBrowseDO;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.error.EmBusinessError;
import com.cuccatch.ubpcp.service.UserBrowseService;
import com.cuccatch.ubpcp.service.model.HistoryModel;
import com.cuccatch.ubpcp.service.model.MovieModel;
import com.cuccatch.ubpcp.service.model.UserBrowseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBrowseServiceImpl implements UserBrowseService {
    @Autowired
    UserBrowseDao userBrowseDao;

    @Autowired
    MovieServiceImpl movieService;

    @Override
    public void saveData(UserBrowseModel userBrowseModel) throws BusinessException {
        try {
            userBrowseDao.save(UserBrowseConverter.convertFromModel(userBrowseModel));
        } catch (Exception e) {
            throw new BusinessException(EmBusinessError.USERBROWSE_SET_FAIL);
        }
    }

    @Override
    public List<HistoryModel> getAllHistoryByUid(Integer uid) throws BusinessException {
        List<UserBrowseDO> userBrowseDOList = new ArrayList<>();
        List<HistoryModel> historyModelList = new ArrayList<>();
        try {
            userBrowseDOList = userBrowseDao.findAllByUserId(uid);
        }catch (Exception e) {
            throw  new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(userBrowseDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.USERBROWSE_NOT_EXIST);
        }
        for(UserBrowseDO b: userBrowseDOList) {
            HistoryModel temp = new HistoryModel();
            MovieModel movieModel = movieService.getMovieById(b.getMovieId());
            temp = HistoryConverter.convertFromMovie(movieModel);
            temp.setUserId(b.getUserId());
            historyModelList.add(temp);
        }
        return historyModelList;
    }
}
