package com.lml.filter;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lml.model.User;
import com.lml.util.ReturnData;
import com.lml.util.TokenUtil;
import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

@ConfigurationProperties("org.my.jwt")
@Getter
@Setter
@Component
@Slf4j
public class JwtTokenFilter implements GlobalFilter, Ordered {

//    @Autowired
//    private  HttpServletRequest request;

    private String jwtSecretKey="asdasfuqiwu1y289yuwqihiuasgd8921893sahdiuqwuieuiahsuidaiushf";
    private String[] skipAuthUrls;
    private String[] tokenInUrls;

    private ObjectMapper objectMapper;

    public JwtTokenFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        List<String> temp = new ArrayList<>(Arrays.asList(exchange.getRequest().getURI().getPath().substring(1).split("/")));
//        temp.remove(0);
//        String url = "/"+StringUtils.join(temp.toArray());
        String url = exchange.getRequest().getURI().getPath();
        String path = exchange.getRequest().getURI().getRawPath();
        for (String skipAuthUrl : skipAuthUrls){
            if(url.contains(skipAuthUrl)){
                return chain.filter(exchange);
            }
        }

        String token = exchange.getRequest().getHeaders().getFirst("Authorization");

        for(String tokenInUrl:tokenInUrls){
            if(url.contains(tokenInUrl)){
                String[] split = url.split("/");
                token = split[split.length-1];
                exchange.getResponse().getHeaders().add("Access-Control-Allow-Methods","GET, POST, OPTIONS");
                exchange.getResponse().getHeaders().add("Access-Control-Allow-Headers","DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Access-Token,Blog-ID");
//                exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin","*");
                String[] tempPath = path.split("/");
                List<String> tmpList = new ArrayList<>(Arrays.asList(tempPath));
                tmpList.remove(tmpList.size()-1);
                path = StringUtils.join(
                        tmpList.toArray(),"/"
                );
                break;

            }
        }

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest newRequest = request.mutate()
                .path(path)
                .build();
        exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, newRequest.getURI());
        ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
        return parseToken(token,newExchange,chain);

    }

    private Mono<Void> parseToken(String token,ServerWebExchange exchange, GatewayFilterChain chain){
        JwtParser parser = Jwts.parser().setSigningKey(jwtSecretKey);


        ServerHttpResponse resp = exchange.getResponse();
        if(StringUtils.isBlank(token)){
            return authErr(resp,"请登录");
        }else {
            try{

                Jwt parse = parser.parse(token);
                Claims claims = (Claims) parse.getBody();
//                TokenUtil.checkToken(token,objectMapper);
                String json = JSON.toJSONString(claims.get("userInfo"));
                User user = JSON.parseObject(json).toJavaObject(User.class);
                ServerHttpRequest request = exchange.getRequest();
                ServerHttpRequest user1 = request.mutate().header("user", json).build();
                ServerWebExchange exchange1 = exchange.mutate().request(user1).build();
                return chain.filter(exchange1);
            }catch (ExpiredJwtException e){
                log.error(e.getMessage(),e);
                if(e.getMessage().contains("Allowed clock skew")){
                    return authErr(resp,"认证过期");
                }else {
                    return authErr(resp,"认证失败");
                }
            }catch (Exception e){
                log.error(e.getMessage(),e);
                return authErr(resp,"认证失败");
            }
        }
    }

    /**
     * 认证错误输出
     * @param resp 响应对象
     * @param mess 错误信息
     * @return
     */
    private Mono<Void> authErr(ServerHttpResponse resp,String mess) {
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
        resp.getHeaders().add("Content-Type","application/json;charset=UTF-8");
        ReturnData<String> returnData = new ReturnData<>(HttpStatus.UNAUTHORIZED.value(), mess, mess);
        String returnStr = "";
        try {
            returnStr = objectMapper.writeValueAsString(returnData);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(),e);
        }
        DataBuffer buffer = resp.bufferFactory().wrap(returnStr.getBytes(StandardCharsets.UTF_8));
        return resp.writeWith(Flux.just(buffer));
    }


    @Override
    public int getOrder() {
        return -999;
    }
}
