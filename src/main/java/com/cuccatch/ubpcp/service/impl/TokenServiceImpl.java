package com.cuccatch.ubpcp.service.impl;

import com.cuccatch.ubpcp.dao.TokenDao;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.error.EmBusinessError;
import com.cuccatch.ubpcp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    TokenDao tokenDao;
    @Override
    public Integer findUidByToken(String token) throws BusinessException {
        try{
            return tokenDao.findByToken(token).getUserid();
        }catch(Exception e) {
            throw new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
    }
}
