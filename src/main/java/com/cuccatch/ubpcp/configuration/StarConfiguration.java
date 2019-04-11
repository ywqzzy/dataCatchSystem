package com.cuccatch.ubpcp.configuration;
import com.cuccatch.ubpcp.interceptor.LoginRequiredInterceptor;
import com.cuccatch.ubpcp.interceptor.PassportInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
public class StarConfiguration implements WebMvcConfigurer {
    @Autowired
    PassportInterceptor passportInterceptor;
    @Autowired
    LoginRequiredInterceptor loginRequiredInterceptor;
    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加自己写的拦截器,这个添加是有先后顺序的
        registry.addInterceptor(passportInterceptor);
        registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/user/change_password");//todo 应该除了少数几个方法都要配置 暂时不管  ！！
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*");
    }
}
