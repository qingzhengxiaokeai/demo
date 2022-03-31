package com.scut.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Jwt {
    /**
     * 过期时间一天，
     * TODO 正式运行时修改为15分钟
     */
    private static final long EXPIRE_TIME=24*60*60*1000;
    /**
     * token私钥
     */
    private static final String TOKEN_SECRET="f26e587c28064d0e855e72c0a6a0e618";
    /**
     * 校验token是否正确
     *
     * @param token 密钥
     * @return 是否正确
     */
    public static  boolean verify(String token){
        try{
            Algorithm algorithm=Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier=JWT.require(algorithm).build();
            DecodedJWT jwt=verifier.verify(token);
            return true;
        }catch(Exception exception){
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static  String getUsername(String token){
        try{
            DecodedJWT jwt=JWT.decode(token);
            return jwt.getClaim("loginName").asString();
        }catch (JWTDecodeException e){
            return null;
        }
    }
    /**
     * 获取登陆用户ID
     * @param token
     * @return
     */
    public static String getUseId(String token){
        try{
            DecodedJWT jwt=JWT.decode(token);
            return jwt.getClaim("userId").asString();
        }catch (JWTDecodeException e){
            return null;
        }
    }

    /**
     * 生成签名,15min后过期
     *
     * @param username 用户名
     * @return 加密的token
     */

}
