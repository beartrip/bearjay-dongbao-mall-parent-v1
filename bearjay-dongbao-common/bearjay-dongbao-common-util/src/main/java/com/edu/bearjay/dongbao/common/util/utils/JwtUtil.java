package com.edu.bearjay.dongbao.common.util.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author langyixiong
 * @date 2021/5/6 17:14
 */
public class JwtUtil {
    private static final String SECRET = "bearjay";
    public static String createToken(String subject) {
        String token = Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 30))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        return token;
    }

    public static String parseToken(String token) {
        String subject = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
        return subject;
    }

    public static void main(String[] args) throws InterruptedException {
        String s = createToken("jay");
        System.out.println("token: " + s);
        TimeUnit.SECONDS.sleep(4);
        s = parseToken(s);
        System.out.println("subject: " + s);
    }
}
