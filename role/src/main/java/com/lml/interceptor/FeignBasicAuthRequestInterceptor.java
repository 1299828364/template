//package com.lml.interceptor;
//
///**
// * @ClassName FeignBasicAuthRequestInterceptor
// * @Description
// * @Author lml
// * @Date2021/2/5 15:51
// * @Version V1.0
// **/
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import io.netty.util.internal.ObjectUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 传递头部用户信息
// */
//@Slf4j
//public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        //通过Request上下文holder获取attributes
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
//                .getRequestAttributes();
//        RequestContextHolder.setRequestAttributes(attributes, true);
//
//        //判断attributes是否为空
//        if(ObjectUtils.isEmpty(attributes)) {
//            return;
//        }
//
//        //从attribute获取user信息
//        HttpServletRequest request = attributes.getRequest();
//        String userInfo = request.getHeader("user");
//
//        //当获取到了就将user信息放到请求的header中
//        if(StringUtils.isNotBlank(userInfo)){
//            requestTemplate.header("user",request.getHeader("user"));
//        }
//    }
//}