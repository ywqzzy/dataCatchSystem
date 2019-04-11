package com.cuccatch.ubpcp.dao;

import com.cuccatch.ubpcp.dataobject.TokenDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface TokenDao extends JpaRepository<TokenDO,Integer> {
    public TokenDO findByToken(String token);

    @Transactional
    @Modifying
    @Query(value = "update TokenDO  set status = :code where token = :token")
    void updateStatus(@Param("token") String token, @Param("code") byte code);
}