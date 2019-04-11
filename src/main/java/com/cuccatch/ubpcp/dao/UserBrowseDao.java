package com.cuccatch.ubpcp.dao;

import com.cuccatch.ubpcp.dataobject.UserBrowseDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBrowseDao extends JpaRepository<UserBrowseDO, Integer> {
    List<UserBrowseDO> findAllByUserId(Integer userId);
}
