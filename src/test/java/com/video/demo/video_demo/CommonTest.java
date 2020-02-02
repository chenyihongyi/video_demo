package com.video.demo.video_demo;

import com.video.demo.video_demo.domain.User;
import com.video.demo.video_demo.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/3 6:53
 */
public class CommonTest {

    @Test
    public void testGeneJwt(){

        User user = new User();
        user.setId(999);
        user.setHeadImg("www.xdclass.net");
        user.setName("xd");

        String token = JwtUtils.geneJsonWebToken(user);
        System.out.println(token);
    }

    @Test
    public void testCheck(){

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjk5OSwibmFtZSI6InhkIiwiaW1nIjoid3d3LnhkY2xhc3MubmV0IiwiaWF0IjoxNTgwNjg0MjAzLCJleHAiOjE1ODEyODkwMDN9.LzDov6y709z8c33qisM-cHcGwCa4X6N55mkhKnsRIw8";
        Claims claims = JwtUtils.checkJWT(token);
        if(claims !=null){
            String name = (String)claims.get("name");
            String img = (String)claims.get("img");
            int id = (Integer)claims.get("id");
            System.out.println(name);
            System.out.println(img);
            System.out.println(id);
        }else{
            System.out.println("非法token");
        }

    }
}
