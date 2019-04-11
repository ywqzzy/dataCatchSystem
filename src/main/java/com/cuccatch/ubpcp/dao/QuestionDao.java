package com.cuccatch.ubpcp.dao;

import com.cuccatch.ubpcp.dataobject.QuestionDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDao extends JpaRepository<QuestionDO, Integer> {
    List<QuestionDO> findByChartID(Integer chartId);
}
