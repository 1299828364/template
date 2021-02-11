package com.lml.util.dao;

import com.alibaba.fastjson.JSON;
import com.lml.model.User;
import com.lml.result.Result;
import com.lml.util.ResultUtil;
import io.jsonwebtoken.*;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName TokenUtil
 * @Description
 * @Author lml
 * @Date2021/2/1 10:42
 * @Version V1.0
 **/

@Slf4j
@Data
@Builder
public class TokenUtil {
    private String token;
    private static String jwtSecretKey="asdasfuqiwu1y289yuwqihiuasgd8921893sahdiuqwuieuiahsuidaiushf";
    private  JwtParser parser;

    public JwtParser getJwtParser(){
        if(parser==null){
            return Jwts.parser().setSigningKey(jwtSecretKey);
        }
        return parser;
    }

    public Result<User> getUser() {
        try {
            JwtParser parser = getJwtParser();
            Jwt parse = parser.parse(token);
            Claims claims = (Claims) parse.getBody();
            String json = JSON.toJSONString(claims.get("userInfo"));
            User user = JSON.parseObject(json).toJavaObject(User.class);
            return ResultUtil.success(user);
        }catch (ExpiredJwtException e){
            if(e.getMessage().contains("Allowed clock skew")){
                log.error("认证过期");
                return ResultUtil.error(401,"认证过期",null);
            }else {
                log.error("认证失败");
                return ResultUtil.error(401,"认证失败",null);
            }
        }catch (Exception e){
            log.error("认证失败");
            return ResultUtil.error(401,"认证失败",null);
        }

    }
}
