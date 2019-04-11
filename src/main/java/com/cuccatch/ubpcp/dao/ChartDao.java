package com.cuccatch.ubpcp.dao;

import com.cuccatch.ubpcp.dataobject.ChartDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartDao extends JpaRepository<ChartDO,Integer> {
}
