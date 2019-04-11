package com.cuccatch.ubpcp.interceptor;


import com.cuccatch.ubpcp.dao.TokenDao;
import com.cuccatch.ubpcp.dao.UserDao;
import com.cuccatch.ubpcp.dataobject.HostHolder;
import com.cuccatch.ubpcp.dataobject.TokenDO;
import com.cuccatch.ubpcp.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class PassportInterceptor implements HandlerInterceptor {

    @Autowired
    TokenDao tokenDao;

    @Autowired
    UserDao userDao;

    @Autowired
    HostHolder hostHolder;

    //判断然后进行用户拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = null;
        System.out.println(request.getParameter("access_token"));
        if(request.getParameter("access_token")!=null) {
            token = request.getParameter("access_token");
        }
        if(token != null ){
            TokenDO tokenDO = tokenDao.findByToken(token);
            // 无效
            if(tokenDO == null || new Date(tokenDO.getExpired()).before(new Date()) || tokenDO.getStatus() != 0){
                return true;
            }
            UserDO userDO = userDao.findById(tokenDO.getUserid()).get();
            hostHolder.setUser(userDO);
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.clear();   //当执行完成之后需要将变量清空
    }
}
