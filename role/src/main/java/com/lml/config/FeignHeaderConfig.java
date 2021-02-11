package com.lml.config;

import com.lml.interceptor.FeignBasicAuthRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName FeignHeaderConfig
 * @Description
 * @Author lml
 * @Date2021/2/5 15:55
 * @Version V1.0
 **/
public class FeignHeaderConfig{
    @Bean
    public RequestInterceptor requestInterceptor(){
        return new FeignBasicAuthRequestInterceptor();
    }
}
