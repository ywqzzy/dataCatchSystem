package com.cuccatch.ubpcp.dao;

import com.cuccatch.ubpcp.dataobject.AnswerDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerDao extends JpaRepository<AnswerDO, Integer> {
    List<AnswerDO> findByUID(Integer uid);
    List<AnswerDO> findByChartID(Integer chartid);
}
