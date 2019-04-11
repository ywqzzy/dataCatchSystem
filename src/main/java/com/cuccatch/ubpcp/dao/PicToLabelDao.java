package com.cuccatch.ubpcp.dao;

import com.cuccatch.ubpcp.dataobject.PicToLabelDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicToLabelDao extends JpaRepository<PicToLabelDO, Integer> {
    PicToLabelDO findOneById(Integer id);
}
