package com.cuccatch.ubpcp.controller;
import com.cuccatch.ubpcp.converter.MovieConverter;
import com.cuccatch.ubpcp.dataobject.HostHolder;
import com.cuccatch.ubpcp.dataobject.MovieDO;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.response.CommonReturnType;
import com.cuccatch.ubpcp.service.MovieService;
import com.cuccatch.ubpcp.service.TokenService;
import com.cuccatch.ubpcp.service.UserBrowseService;
import com.cuccatch.ubpcp.service.UserService;
import com.cuccatch.ubpcp.service.model.MovieModel;
import com.cuccatch.ubpcp.service.model.UserBrowseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/movie")
public class MovieController extends BaseController{
    @Autowired
    MovieService movieService;

    @Autowired
    HostHolder hostHolder;

    @Autowired
    UserBrowseService userBrowseService;

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @GetMapping("/get/{mid}")
    public CommonReturnType getMovie(@RequestParam String access_token,@PathVariable Integer mid) throws BusinessException {
        if(hostHolder.getUser() != null) {
           // 埋点
            UserBrowseModel model = new UserBrowseModel();
            Date date = new Date();
            model.setCtime(date.getTime());
            model.setMovieId(mid);
            // 根据token 找uid
            Integer uid = tokenService.findUidByToken(access_token);
            model.setUserId(uid);
            // model.setUserId();
            userBrowseService.saveData(model);
            // 更新浏览次数信息
            userService.updateBrowseCount(uid);

        }
        MovieModel movieModel = movieService.getMovieById(mid);
        return CommonReturnType.createSuccess(movieModel, "success");

    }
    @GetMapping("/getMovies")
    public CommonReturnType getMovies() throws BusinessException {
        List<MovieModel> movieModelList = movieService.getAllMovies();
       return CommonReturnType.createSuccess(movieModelList, "success");
    }

    @GetMapping("/get")
    public CommonReturnType getMovieByPage(@RequestParam Integer page) throws BusinessException {
        Page<MovieDO> movieDOS = movieService.getMovieByPage(page, 10);
        List<MovieDO> movieDOList = movieDOS.getContent();
        List<MovieModel> movieModelList = new ArrayList<>();
        for(MovieDO m: movieDOList) {
            movieModelList.add(MovieConverter.convertFromDataObject(m));
        }
        return CommonReturnType.createSuccess(movieModelList,"success");
    }

    @GetMapping("/getByYear")
    public CommonReturnType getMovieByYear(@RequestParam String year) throws BusinessException {
        List<MovieModel> movieModelList = movieService.getMovieByYear(year);
        return CommonReturnType.createSuccess(movieModelList,"success");
    }

    @GetMapping("/getByType")
    public CommonReturnType getMovieByType(@RequestParam String type) throws BusinessException {
        List<MovieModel> movieModelList = movieService.getMovieByType(type);
        return CommonReturnType.createSuccess(movieModelList,"success");
    }

    @GetMapping("/getRelative")
    public CommonReturnType getRelativeMovie(@RequestParam String type) throws BusinessException {

        List<MovieModel> movieModelList = movieService.getRelativeMovie(type);
        return CommonReturnType.createSuccess(movieModelList,"success");
    }

    @GetMapping("/getByPlace")
    public CommonReturnType getByPlace(@RequestParam String place) throws BusinessException {
        List<MovieModel> movieModelList = movieService.getByPlace(place);
        return CommonReturnType.createSuccess(movieModelList,"success");
    }

    @GetMapping("/getByDirector")
    public CommonReturnType getByDirector(@RequestParam String director) throws BusinessException {
        List<MovieModel> movieModelList = movieService.getByDirector(director);
        return CommonReturnType.createSuccess(movieModelList,"success");
    }
}
