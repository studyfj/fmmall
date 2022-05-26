package com.itcast.config;

import com.itcast.interceptor.CheckTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/21 14:53
 * @Description 致敬大师，致敬未来的自己
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        CheckTokenInterceptor checkTokenInterceptor = new CheckTokenInterceptor();
        registry.addInterceptor(checkTokenInterceptor).addPathPatterns("/shopcart/**").order(1);
    }
}
