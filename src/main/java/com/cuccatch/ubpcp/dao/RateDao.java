package com.cuccatch.ubpcp.dao;

import com.cuccatch.ubpcp.dataobject.RateDO;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RateDao extends JpaRepository<RateDO,Integer> {

    List<RateDO> findByUidAndMovieName(Integer uid, String movieName);
    List<RateDO> findByUid(Integer uid);
    List<RateDO> findByMovieName(String movieName);

}
