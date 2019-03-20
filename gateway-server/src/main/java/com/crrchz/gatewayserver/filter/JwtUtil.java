package com.crrchz.gatewayserver.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;

import javax.naming.NoPermissionException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/16 0:23
 */
public class JwtUtil {
    public static final String SECRET = "qazwsx123444$#%#()*&& asdaswwi1235 ?;!@#kmmmpom in***xx**&";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_AUTH = "Authorization";

    //jwt生成token[id+user]
    public static String generateToken(String user) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", new Random().nextInt());
        map.put("user", user);
        String jwt = Jwts.builder()
                .setSubject("user info").setClaims(map)
                .signWith(SignatureAlgorithm.HS512, SECRET)//用的是上面一串密码进行签名
                .compact();
        String finalJwt = TOKEN_PREFIX + " " +jwt;
        return finalJwt;
    }

    //token的信息验证
    public static Map<String,String> validateToken(String token) {
        if (token != null) {
            HashMap<String, String> map = new HashMap<String, String>();
            Map<String,Object> body = Jwts.parser()  //解密
                    .setSigningKey(SECRET)//加签名
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String id =  String.valueOf(body.get("id"));
            String user = (String) (body.get("user"));
            map.put("id", id);
            map.put("user", user);
            if(StringUtils.isEmpty(user)) {
                //throw new NoPermissionException("user is error, please check");
                System.out.println("user is error, please check");
                return  null;
            }
            return map;
        } else {
            //throw new NoPermissionException("token is error, please check");
            System.out.println("token is error, please check");
            return  null;
        }
    }

}
