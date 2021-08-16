package com.soul.adapter.impl;

/**
 * @author Rich_fu
 * @date 2021/4/11
 *  加密适配器类
 */
public class CipherAdapter implements DataOperation{
    private Adaptee adaptee;

    public CipherAdapter() {
        this.adaptee = new Adaptee();
    }

    @Override
    public String doEncrypt(String ps) {
        return adaptee.doEncrypt(ps);
    }
}
