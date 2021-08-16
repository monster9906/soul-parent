package com.soul.adapter.impl;

/**
 * @author Rich_fu
 * @date 2021/4/11
 * 适配者类
 */
public class Adaptee {
    public String doEncrypt(String ps) {
        return EncryptUtils.encrypt(ps);
    }
}
