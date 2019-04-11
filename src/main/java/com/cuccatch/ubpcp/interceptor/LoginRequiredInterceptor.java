package com.cuccatch.ubpcp.interceptor;


import com.cuccatch.ubpcp.dataobject.HostHolder;
import com.cuccatch.ubpcp.error.BusinessException;
import com.cuccatch.ubpcp.error.EmBusinessError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果说现在是没有用户登录的
        if(hostHolder.getUser() == null){
            // todo  满足接口要求
           throw new BusinessException(EmBusinessError.NOT_LOGIN);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
