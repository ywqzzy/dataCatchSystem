package com.cuccatch.ubpcp.service;

import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.service.model.UserModel;

import java.util.Map;

public interface UserService {
    UserModel getUserByUsername(String username);

    Map<String,Object> register(String username, String password) throws BusinessException;
    Map<String,Object> login(UserModel userModel) throws BusinessException;
    void logout(String ticket) throws BusinessException;
    boolean changePwd(String username,String pwd) throws BusinessException;
    boolean updateBrowseCount(Integer uid) throws BusinessException;
    void updatePid(Integer uid) throws BusinessException;
    void updateRateCount(Integer uid) throws BusinessException;


}
