package com.cuccatch.ubpcp.controller;


import com.cuccatch.ubpcp.dataobject.HostHolder;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.response.CommonReturnType;
import com.cuccatch.ubpcp.response.EmReturnStatusCode;
import com.cuccatch.ubpcp.service.AnswerService;
import com.cuccatch.ubpcp.service.UserBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history")
public class HistoryController extends BaseController {
    @Autowired
    UserBrowseService userBrowseService;
    @Autowired
    HostHolder hostHolder;
    @GetMapping("/get/{uid}")
    public CommonReturnType getByUid(@PathVariable Integer uid) throws BusinessException {
        //if(hostHolder.getUser() != null) {
            return CommonReturnType.createSuccess(userBrowseService.getAllHistoryByUid(uid),"success");
        //}
        //return CommonReturnType.createPlainText("用户未登陆", EmReturnStatusCode.COMMON_FAIL);
    }
}
