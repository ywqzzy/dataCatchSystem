package com.cuccatch.ubpcp.controller;

import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.response.CommonReturnType;
import com.cuccatch.ubpcp.response.EmReturnStatusCode;
import com.cuccatch.ubpcp.service.RateService;
import com.cuccatch.ubpcp.service.UserService;
import com.cuccatch.ubpcp.service.model.RateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rate")
public class RateController extends BaseController{
    @Autowired
    RateService rateService;
    @Autowired
    UserService userService;

    @PostMapping("/set")
    public CommonReturnType setRate(@RequestBody RateModel rateModel) throws BusinessException {
        rateService.setRate(rateModel);
        userService.updateRateCount(rateModel.getUid());
        return CommonReturnType.createPlainText("success", EmReturnStatusCode.COMMON_SUCCESS);
    }

    @GetMapping("/getByName/{movieName}")
    public CommonReturnType getByName( @PathVariable String movieName) throws BusinessException {
        List<RateModel> rateModelList= rateService.getRateByMovieName(movieName);
        return CommonReturnType.createSuccess(rateModelList, "success");
    }

    @GetMapping("/get/{uid}")
    public CommonReturnType getUserRate(@PathVariable Integer uid) throws BusinessException {
        List<RateModel> rateModelList = rateService.getRateByUid(uid);
        return CommonReturnType.createSuccess(rateModelList, "success");
    }

    @GetMapping("/checkRate")
    public CommonReturnType checkRate(@RequestParam Integer uid,@RequestParam String movieName) throws BusinessException {
        boolean flag = rateService.checkRate(uid,movieName);
        if(flag) return CommonReturnType.createSuccess(null, "success");
        else return CommonReturnType.createPlainText("已评分",EmReturnStatusCode.COMMON_FAIL);
    }

    @GetMapping("/getRateByMovieNameAndUid")
    public CommonReturnType getRateByMovieNameAndUid(@RequestParam Integer uid,@RequestParam String movieName) throws BusinessException {
        List<RateModel> rateModelList= rateService.getRate(uid,movieName);
        return CommonReturnType.createSuccess(rateModelList.get(0),"success");
    }
}
