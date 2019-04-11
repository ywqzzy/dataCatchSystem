package com.cuccatch.ubpcp.service.impl;

import com.cuccatch.ubpcp.converter.UserConverter;
import com.cuccatch.ubpcp.dao.TokenDao;
import com.cuccatch.ubpcp.dao.UserDao;
import com.cuccatch.ubpcp.dataobject.TokenDO;
import com.cuccatch.ubpcp.dataobject.UserDO;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.error.EmBusinessError;
import com.cuccatch.ubpcp.service.UserService;
import com.cuccatch.ubpcp.service.model.UserModel;
import com.cuccatch.ubpcp.utils.MD5Util;
import com.cuccatch.ubpcp.validator.ValidationResult;
import com.cuccatch.ubpcp.validator.ValidatorImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    TokenDao tokenDao;
    @Autowired
    private ValidatorImpl validator;
    @Override
    public UserModel getUserByUsername(String username) {
        UserDO userDO = null;
        try {
            userDO = userDao.findByUsername(username);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if(userDO == null) {
            return null;
        }
        return UserConverter.convertFromDataObject(userDO);
    }

    @Override
    public Map<String, Object> register(String username, String password) throws BusinessException {
        Map<String, Object> res = new HashMap<>();

        if(StringUtils.isEmpty(username)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        if(StringUtils.isEmpty(password)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);

        }
        UserDO userDO = userDao.findByUsername(username);
        if(userDO != null) {
            throw new BusinessException(EmBusinessError.USER_EXIST);
        }
        userDO = new UserDO();
        userDO.setUsername(username);
        userDO.setEncryptPwd(MD5Util.MD5(password));
        userDO.setRateCount(0);
        userDO.setBrowseCount(0);
        userDO.setPid(1);
        userDao.save(userDO);
        String token = addToken(userDO.getId());
        res.put("access_token",token);
        res.put("username",username);
        res.put("pid",1);
        res.put("uid",userDO.getId());
        return res;
    }

    @Override
    public Map<String, Object> login(UserModel userModel) throws BusinessException {
        Map<String,Object> map = new HashMap<String,Object>();
        ValidationResult res = validator.validate(userModel);
        if(res.isHasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,res.getErrMsg());
        }

        UserDO userDO = userDao.findByUsernameAndEncryptPwd(userModel.getUsername(),userModel.getEncrypt_pwd());

        if(userDO == null) {
            map.put("msg","密码错误");
            return map;
        }
        String token = addToken(userDO.getId());
        map.put("access_token",token);
        map.put("username",userModel.getUsername());
        map.put("pid",userDO.getPid());
        map.put("uid",userDO.getId());
        return map;
    }

    @Override
    public void logout(String token) throws BusinessException {
        try {
            tokenDao.updateStatus(token, (byte)1);
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.TOKEN_SET_FAIL);
        }
    }

    @Override
    public boolean changePwd(String username, String pwd) throws BusinessException {
        try {
            userDao.updatePWD(username, MD5Util.MD5(pwd));
        } catch (Exception e) {
            //   todo 改error类型
            throw  new BusinessException(EmBusinessError.UNKNOWN_ERROR);
        }
        return true;
    }

    @Override
    public boolean updateBrowseCount(Integer uid) throws BusinessException {
        try {
            userDao.updateBrowseCount(uid);
        } catch (Exception e) {
            //   todo 改error类型
            throw  new BusinessException(EmBusinessError.UNKNOWN_ERROR);
        }
        return true;
    }

    @Override
    public void updatePid(Integer uid) throws BusinessException {
        try {
            userDao.updatePid(uid);
        } catch (Exception e) {
            throw  new BusinessException(EmBusinessError.UNKNOWN_ERROR);
        }
    }

    @Override
    public void updateRateCount(Integer uid) throws BusinessException {
        try {
            userDao.updateRateCount(uid);
        } catch (Exception e) {
            throw  new BusinessException(EmBusinessError.UNKNOWN_ERROR);
        }
    }
    private String addToken(int userId) throws BusinessException {
        TokenDO tokenDO = new TokenDO();
        tokenDO.setUserid(userId);
        tokenDO.setExpired(3600*24*100 + new Date().getTime());
        tokenDO.setStatus(new Byte("0"));
        tokenDO.setToken(UUID.randomUUID().toString().replaceAll("_",""));
        try {
            tokenDao.save(tokenDO);
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.TOKEN_SET_FAIL);
        }
        return tokenDO.getToken();
    }
}
