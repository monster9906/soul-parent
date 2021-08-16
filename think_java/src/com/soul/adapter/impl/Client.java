package com.soul.adapter.impl;

/**
 * @author Rich_fu
 * @date 2021/4/11
 */
public class Client {
    public static void main(String[] args) {
        // 被加密字符串
        String password = "123456";

        // 对象适配器
        DataOperation data = new CipherAdapter();
        String s2 = data.doEncrypt(password);
        System.out.println("对象适配器加密前的密钥："+password+"，加密后的密钥："+s2);

        // 类适配器
        DataOperation dataOperation = new CipherAdapterClass();
        String s = dataOperation.doEncrypt(password);
        System.out.println("类适配器加密前的密钥："+password+"，加密后的密钥："+s2);
    }
}
