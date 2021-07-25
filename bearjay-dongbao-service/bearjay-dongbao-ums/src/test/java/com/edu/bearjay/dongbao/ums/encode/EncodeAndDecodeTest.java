package com.edu.bearjay.dongbao.ums.encode;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * @author langyixiong
 * @date 2021/4/18 16:13
 */
public class EncodeAndDecodeTest {
    @Test
    public void md5() {
        String source = "zard";
        String target = DigestUtils.md5DigestAsHex(source.getBytes());
        System.out.println("first: " + target);
        target = DigestUtils.md5DigestAsHex(source.getBytes());
        System.out.println("second: " + target);
    }

    @Test
    public void bcrypt() {
        String source = "zard";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String target = bCryptPasswordEncoder.encode(source);
        boolean isMatches = bCryptPasswordEncoder.matches(source, target);
        System.out.println("first: " + target);
        System.out.println("是否匹配: " + isMatches);
        target = bCryptPasswordEncoder.encode(source);
        isMatches = bCryptPasswordEncoder.matches(source, target);
        System.out.println("second: " + target);
        System.out.println("是否匹配: " + isMatches);
    }
}
