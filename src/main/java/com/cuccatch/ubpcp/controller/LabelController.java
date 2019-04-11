package com.cuccatch.ubpcp.controller;


import com.cuccatch.ubpcp.dataobject.HostHolder;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.response.CommonReturnType;
import com.cuccatch.ubpcp.response.EmReturnStatusCode;
import com.cuccatch.ubpcp.service.LabelService;
import com.cuccatch.ubpcp.service.UserService;
import com.cuccatch.ubpcp.service.model.LabelResultModel;
import com.cuccatch.ubpcp.service.model.PicToLabelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/label")
public class LabelController extends BaseController{
    @Autowired
    LabelService labelService;

    @Autowired
    UserService userService;

    @Autowired
    HostHolder hostHolder;

    @GetMapping("/addLabel")
    public CommonReturnType addLabel(Integer uid, Integer pid, String label) throws BusinessException {
        LabelResultModel resultModel = new LabelResultModel();
        resultModel.setUid(uid);
        resultModel.setPid(pid);
        resultModel.setLabel(label);
        labelService.saveUserLabel(resultModel);
        userService.updatePid(resultModel.getUid());
        return CommonReturnType.createPlainText("success", EmReturnStatusCode.COMMON_SUCCESS);
    }

    @GetMapping("/addPicToLabel")
    public CommonReturnType addPicToLabel(@RequestBody PicToLabelModel res) throws BusinessException {
        labelService.addPicToLabel(res);
        return CommonReturnType.createPlainText("success", EmReturnStatusCode.COMMON_SUCCESS);
    }

    @GetMapping("/getPicToLabel/{pid}")
    public CommonReturnType getPicToLabel(@PathVariable Integer pid) throws BusinessException {
        PicToLabelModel res = labelService.getPicToLabel(pid);
        return CommonReturnType.createSuccess(res,"success");
    }

    @GetMapping("/getLabelResultByUid/{uid}")
    public CommonReturnType getByUid(@PathVariable Integer uid) throws BusinessException {
        List<LabelResultModel> res = labelService.getLabelResultByUid(uid);
        return CommonReturnType.createSuccess(res,"success");
    }

    @GetMapping("/getLabelResultByPid/{pid}")
    public CommonReturnType getByPid(@PathVariable Integer pid) throws BusinessException {

        List<LabelResultModel> res = labelService.getLabelResultByPid(pid);
        return CommonReturnType.createSuccess(res,"success");
    }
}
