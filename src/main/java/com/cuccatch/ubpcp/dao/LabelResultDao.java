package com.cuccatch.ubpcp.dao;

import com.cuccatch.ubpcp.dataobject.LabelResultDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabelResultDao extends JpaRepository<LabelResultDO, Integer> {
    List<LabelResultDO> findByUid(Integer uid);
    List<LabelResultDO> findByPid(Integer pid);
}
