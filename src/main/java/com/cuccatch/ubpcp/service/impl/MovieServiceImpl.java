package com.cuccatch.ubpcp.service.impl;

import com.cuccatch.ubpcp.converter.MovieConverter;
import com.cuccatch.ubpcp.dao.MovieDao;
import com.cuccatch.ubpcp.dataobject.MovieDO;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.error.EmBusinessError;
import com.cuccatch.ubpcp.service.MovieService;
import com.cuccatch.ubpcp.service.model.MovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieDao movieDao;

    @Override
    public MovieModel getMovieById(Integer id) throws BusinessException {
        try{
            MovieDO movieDO = movieDao.getOne(id);
            return MovieConverter.convertFromDataObject(movieDO);
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.MOVIE_NOT_EXIST);
        }
        
    }

    @Override
    public Page<MovieDO> getMovieByPage(Integer page, Integer size) throws BusinessException {
        PageRequest pageable = PageRequest.of(page-1, size, Sort.Direction.ASC, "id");
        try{
            return movieDao.findAll(pageable);
        }catch (Exception e) {
            throw new BusinessException(EmBusinessError.MOVIE_NOT_EXIST);
        }
    }

    @Override
    public List<MovieModel> getAllMovies() throws BusinessException {
        List<MovieDO> movieDOList = new ArrayList<>();
        List<MovieModel> movieModelList = new ArrayList<>();
        try {
            movieDOList = movieDao.findAll();
        }catch (Exception e) {
            throw  new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(movieDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.MOVIE_NOT_EXIST);
        }
        for(MovieDO m: movieDOList) {
            movieModelList.add(MovieConverter.convertFromDataObject(m));
        }
        return movieModelList;
    }

    @Override
    public List<MovieModel> getMovieByYear(String year) throws BusinessException {
        List<MovieDO> movieDOList = new ArrayList<>();
        List<MovieModel> movieModelList = new ArrayList<>();
        try {
            movieDOList = movieDao.findByYearLike("%"+year+"%");
        }catch (Exception e) {
            throw  new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(movieDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.MOVIE_NOT_EXIST);
        }
        for(MovieDO m: movieDOList) {
            movieModelList.add(MovieConverter.convertFromDataObject(m));
        }
        return movieModelList;
    }

    @Override
    public List<MovieModel> getMovieByType(String type) throws BusinessException {
        List<MovieDO> movieDOList = new ArrayList<>();
        List<MovieModel> movieModelList = new ArrayList<>();
        try {
            movieDOList = movieDao.findByTypeLike("%"+type+"%");
        }catch (Exception e) {
            throw  new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(movieDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.MOVIE_NOT_EXIST);
        }
        for(MovieDO m: movieDOList) {
            movieModelList.add(MovieConverter.convertFromDataObject(m));
        }
        return movieModelList;
    }

    @Override
    public List<MovieModel> getRelativeMovie(String type) throws BusinessException {
        String [] arr = type.split("\\s+");
        List<MovieDO> movieDOList = new ArrayList<>();
        List<MovieModel> movieModelList = new ArrayList<>();
        for(String tmpType : arr){
            List<MovieDO> newList = new ArrayList<>();
            newList = movieDao.findByTypeLike("%"+tmpType+"%");
            for(MovieDO tm: newList) {
                movieDOList.add(tm);
            }
        }
        if(movieDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.MOVIE_NOT_EXIST);
        }
        for(MovieDO mm: movieDOList) {
            movieModelList.add(MovieConverter.convertFromDataObject(mm));
        }
        return movieModelList;
    }

    @Override
    public List<MovieModel> getByPlace(String place) throws BusinessException {
        List<MovieDO> movieDOList = new ArrayList<>();
        List<MovieModel> movieModelList = new ArrayList<>();
        try {
            movieDOList = movieDao.findByCountryLike("%"+place+"%");
        }catch (Exception e) {
            throw  new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(movieDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.MOVIE_NOT_EXIST);
        }
        for(MovieDO m: movieDOList) {
            movieModelList.add(MovieConverter.convertFromDataObject(m));
        }
        return movieModelList;
    }

    @Override
    public List<MovieModel> getByDirector(String director) throws BusinessException {
        List<MovieDO> movieDOList = new ArrayList<>();
        List<MovieModel> movieModelList = new ArrayList<>();
        try {
            movieDOList = movieDao.findByDirector(director);
        }catch (Exception e) {
            throw  new BusinessException(EmBusinessError.DATABASE_ERROR);
        }
        if(movieDOList.isEmpty()) {
            throw new BusinessException(EmBusinessError.MOVIE_NOT_EXIST);
        }
        for(MovieDO m: movieDOList) {
            movieModelList.add(MovieConverter.convertFromDataObject(m));
        }
        return movieModelList;
    }
}
