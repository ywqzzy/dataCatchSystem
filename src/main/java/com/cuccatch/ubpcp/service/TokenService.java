package com.cuccatch.ubpcp.service;

import com.cuccatch.ubpcp.error.BusinessException;

public interface TokenService {
    Integer findUidByToken(String token) throws BusinessException;
}
