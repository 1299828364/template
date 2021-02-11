package com.lml.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lml.dto.UserDto;
import com.lml.model.User;
import com.lml.result.Result;
import com.lml.service.GateWayUserService;
import com.lml.util.ResultUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class loginController {

//    @Autowired
//    UserQueryProvider userQueryProvider;

    @Autowired
    GateWayUserService gateWayUserService;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${org.my.jwt.effective-time}")
    private String effectiveTime;

//    @Value("${jwt.secret-key}")
    private String jwtSecretKey="asdasfuqiwu1y289yuwqihiuasgd8921893sahdiuqwuieuiahsuidaiushf";

    @RequestMapping("/login")
    public Result<Object> login(@RequestBody UserDto userDTO) throws JsonProcessingException {
        User user = gateWayUserService.getUserByUserName(userDTO.getUserName());
        if (Objects.isNull(user)) {
            return ResultUtil.error("账户不存在");
        }
        String token;
        if (user.getPassword().equals(userDTO.getPassword())) {

            Map<String, Object> claims = new HashMap<>();
            claims.put("userInfo", user);

            token = Jwts.builder()
                    .setSubject(user.getUserName())
                    .signWith(SignatureAlgorithm.HS256, jwtSecretKey)
                    .setIssuedAt(new Date())
                    .setClaims(claims)
                    .setExpiration(Date.from(Instant.now().plus(20000, ChronoUnit.MINUTES)))
                    .compact();

        } else {
            return ResultUtil.error("密码错误");
        }
        return ResultUtil.success(token);
    }
}
