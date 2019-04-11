package com.cuccatch.ubpcp.controller;


import com.cuccatch.ubpcp.dataobject.HostHolder;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.error.EmBusinessError;
import com.cuccatch.ubpcp.response.CommonReturnType;
import com.cuccatch.ubpcp.response.EmReturnStatusCode;
import com.cuccatch.ubpcp.service.UserService;
import com.cuccatch.ubpcp.service.model.UserModel;
import com.cuccatch.ubpcp.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    UserService userService;
    @Autowired
    HostHolder hostHolder;

    @GetMapping("/getInfo")
    public CommonReturnType getInfo(@RequestParam(name = "username") String username) {
        UserModel userModel = userService.getUserByUsername(username);
        userModel.setEncrypt_pwd("");
        return CommonReturnType.createSuccess(userModel, "success");
    }


    @GetMapping("/register")
    public CommonReturnType register( @RequestParam("username") String username,
                                      @RequestParam("password") String password) throws BusinessException {
        Map<String,Object> res = userService.register(username,password);

        if(res.containsKey("access_token")) {
            return CommonReturnType.createSuccess(res,"注册成功");
        }else {
            return CommonReturnType.create(null,"注册失败", EmReturnStatusCode.REGISTER_FAIL);
        }
    }


    @GetMapping("/login")
    public CommonReturnType login(String username, String password) throws BusinessException {
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        if(StringUtils.isEmpty(username) ||
                StringUtils.isEmpty(password)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        UserModel userModel = new UserModel();
        userModel.setEncrypt_pwd(MD5Util.MD5(password));
        userModel.setUsername(username);
        Map<String, Object> res = userService.login(userModel);
        return CommonReturnType.createSuccess(res, "success");
    }

    @GetMapping("/logout")
    public CommonReturnType logout(HttpServletRequest request) throws BusinessException {
        userService.logout(request.getParameter("access_token"));
        return CommonReturnType.createPlainText("退出登陆成功", EmReturnStatusCode.COMMON_SUCCESS);
    }


    @GetMapping("/change_password")
    public CommonReturnType changePwd(HttpServletRequest request) throws BusinessException {
        if(hostHolder.getUser() == null) {
            return CommonReturnType.createPlainText("用户未登陆",EmReturnStatusCode.COMMON_FAIL);
        }
        boolean flag = userService.changePwd(request.getParameter("username"),request.getParameter("new_password"));
        if(flag) {
            return CommonReturnType.createPlainText("修改密码成功",EmReturnStatusCode.COMMON_SUCCESS);
        } else {
            return CommonReturnType.createPlainText("修改密码失败",EmReturnStatusCode.COMMON_FAIL);
        }
    }
}
