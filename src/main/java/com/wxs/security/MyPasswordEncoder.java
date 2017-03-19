package com.wxs.security;

import org.springframework.security.authentication.encoding.BasePasswordEncoder;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.codec.Utf8;

/**
 *  自定义密码验证
 * Created by wuxusen on 2017/3/18.
 */
public class MyPasswordEncoder extends BasePasswordEncoder {

    public MyPasswordEncoder() {
    }

    public String encodePassword(String rawPass, Object salt) {
        return this.mergePasswordAndSalt(rawPass, salt, true);
    }

    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        String pass1 = encPass; // 库里的加密后的密码
        Md5PasswordEncoder md5 =  new Md5PasswordEncoder(); // todo 可以提供一个md5 的工具类
        String pass2 = md5.encodePassword(rawPass,null);
        return this.equals(pass1, pass2);
    }


    private  boolean equals(String expected, String actual) {
        byte[] expectedBytes = bytesUtf8(expected);
        byte[] actualBytes = bytesUtf8(actual);
        int expectedLength = expectedBytes == null?-1:expectedBytes.length;
        int actualLength = actualBytes == null?-1:actualBytes.length;
        int result = expectedLength == actualLength?0:1;

        for(int i = 0; i < actualLength; ++i) {
            byte expectedByte = expectedLength <= 0?0:expectedBytes[i % expectedLength];
            byte actualByte = actualBytes[i % actualLength];
            result |= expectedByte ^ actualByte;
        }

        return result == 0;
    }
    private  byte[] bytesUtf8(String s) {
        return s == null?null: Utf8.encode(s);
    }
}
