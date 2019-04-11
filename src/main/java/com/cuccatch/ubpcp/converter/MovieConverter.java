package com.cuccatch.ubpcp.converter;

import com.cuccatch.ubpcp.dataobject.MovieDO;
import com.cuccatch.ubpcp.service.model.MovieModel;
import org.springframework.beans.BeanUtils;

public class MovieConverter {
    public static MovieModel convertFromDataObject(MovieDO MovieDO) {
        if(MovieDO==null) return null;
        MovieModel MovieModel = new MovieModel();
        BeanUtils.copyProperties(MovieDO,MovieModel);
        return MovieModel;
    }
}
