package com.cuccatch.ubpcp.service;

import com.cuccatch.ubpcp.dataobject.MovieDO;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.service.model.MovieModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MovieService {

    MovieModel getMovieById(Integer id) throws BusinessException;
    Page<MovieDO> getMovieByPage(Integer page, Integer size) throws BusinessException;
    List<MovieModel> getAllMovies() throws BusinessException;
    List<MovieModel> getMovieByYear(String year) throws BusinessException;
    List<MovieModel> getMovieByType(String type) throws BusinessException;
    List<MovieModel> getRelativeMovie(String type) throws BusinessException;
    List<MovieModel> getByPlace(String place) throws BusinessException;
    List<MovieModel> getByDirector(String director) throws BusinessException;



}
