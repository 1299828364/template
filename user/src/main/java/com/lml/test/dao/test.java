package com.lml.test.dao;

import com.lml.model.User;
import com.lml.result.Result;
import com.lml.util.RoleTest;
import com.lml.util.dao.TokenUtil;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping
public class test {

    @RoleTest(hasRole = "会员")
    @RequestMapping(value = "/getVideo/{token}", method = RequestMethod.GET)
    @ResponseBody
    public void getVideo(@PathVariable("token") String token, HttpServletRequest request, HttpServletResponse response) {
        TokenUtil tokenUtil = TokenUtil.builder().token(token).build();
        Result<User> userInfo = tokenUtil.getUser();
        if(userInfo.getCode()==401){
            try {
                response.sendError(401);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

//        String file = "E:\\graduationDesign\\template\\testWeb\\resource\\test1.mp4";
        String file = "D:\\bilibili\\15223201\\1\\15223201_1_0.flv";
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//            FileInputStream inputStream = new FileInputStream(file);
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            String diskfilename = "15223201_1_0.flv";
//            String diskfilename = "final.mp4";
            response.setContentType("video/flv");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + diskfilename + "\"");

//            response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS" );
//            response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Access-Token,Blog-ID" );
            response.setHeader("Access-Control-Allow-Origin", "*" );

            System.out.println("data.length " + data.length);
            response.setContentLength(data.length);
            response.setHeader("Content-Range", "" + Integer.valueOf(data.length - 1));
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Etag", "W/\"9767057-1323779115364\"");
            OutputStream os = response.getOutputStream();

            os.write(data);
            //先声明的流后关掉！
            os.flush();
            os.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }



    @RoleTest(hasRole = "会员")
    @RequestMapping(value = "/getVideo1/{token}", method = RequestMethod.GET)
    @ResponseBody
    public void mp4Test(@PathVariable("token") String token, HttpServletRequest request, HttpServletResponse response) {
        TokenUtil tokenUtil = TokenUtil.builder().token(token).build();
        Result<User> userInfo = tokenUtil.getUser();
        if(userInfo.getCode()==401){
            try {
                response.sendError(401);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        String file = "C:\\Users\\18716\\Desktop\\蜜汁文件夹\\两江人工智能学院关于开展学生廉洁诚信教育主题班团会的通知\\附件1\\诚信教育宣传片.mp4";
//        String file = "D:\\bilibili\\15223201\\1\\15223201_1_0.flv";
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//            FileInputStream inputStream = new FileInputStream(file);
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
//            String diskfilename = "15223201_1_0.flv";
            String diskfilename = "final.mp4";
//            response.setContentType("video/flv");
            response.setContentType("video/mp4");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + diskfilename + "\"");

//            response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS" );
//            response.setHeader("Access-Control-Allow-Headers", "DNT,X-Mx-ReqToken,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Access-Token,Blog-ID" );
//            response.setHeader("Access-Control-Allow-Origin", "*" );

            System.out.println("data.length " + data.length);
            response.setContentLength(data.length);
            response.setHeader("Content-Range", "" + Integer.valueOf(data.length - 1));
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Etag", "W/\"9767057-1323779115364\"");
            OutputStream os = response.getOutputStream();

            os.write(data);
            //先声明的流后关掉！
            os.flush();
            os.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }
}
