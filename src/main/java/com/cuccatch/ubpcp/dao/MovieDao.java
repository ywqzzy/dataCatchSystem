package com.cuccatch.ubpcp.dao;

import com.cuccatch.ubpcp.dataobject.MovieDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieDao extends JpaRepository<MovieDO, Integer> {
    List<MovieDO> findByYearLike(String year);
    List<MovieDO> findByTypeLike(String type);
    List<MovieDO> findByCountryLike(String type);
    List<MovieDO> findByDirector(String director);
}
