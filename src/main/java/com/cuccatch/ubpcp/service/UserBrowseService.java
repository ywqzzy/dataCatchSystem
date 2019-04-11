package com.cuccatch.ubpcp.service;

import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.service.model.HistoryModel;
import com.cuccatch.ubpcp.service.model.UserBrowseModel;

import java.util.List;

public interface UserBrowseService {
    void saveData(UserBrowseModel userBrowseModel) throws BusinessException;
    List<HistoryModel> getAllHistoryByUid(Integer uid) throws BusinessException;
}
