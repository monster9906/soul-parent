package com.soul.adapter.impl;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Rich_fu
 * @date 2021/4/11
 * 加密工具类
 */
public class EncryptUtils {

    /**
     * 加密方法
     * @param str
     * @return
     */
    public static String encrypt(String str){
        String encode = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            encode = base64Encoder.encode(md5.digest(str.getBytes()));
            return encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return encode;
    }

}
