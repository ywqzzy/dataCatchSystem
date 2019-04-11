package com.cuccatch.ubpcp.dao;

import com.cuccatch.ubpcp.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface UserDao  extends JpaRepository<UserDO, Integer> {
    public UserDO findByUsername(String username);

    public UserDO findByUsernameAndEncryptPwd(String username,String pwd);

    @Transactional
    @Modifying
    @Query(value = "update UserDO  set encryptPwd = :encryptPwd where username = :username")
    public void updatePWD(@Param("username") String username, @Param("encryptPwd") String encryptPwd);

    @Transactional
    @Modifying
    @Query(value = "update UserDO  set browseCount = browseCount + 1 where id = :uid")
    public void updateBrowseCount(@Param("uid") Integer uid);

    @Transactional
    @Modifying
    @Query(value = "update UserDO  set pid = pid + 1 where id = :uid")
    public void updatePid(@Param("uid") Integer uid);

    @Transactional
    @Modifying
    @Query(value = "update UserDO  set rateCount = rateCount + 1 where id = :uid")
    public void updateRateCount(@Param("uid") Integer uid);
}
