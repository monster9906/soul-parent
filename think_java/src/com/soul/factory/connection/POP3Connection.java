package com.soul.factory.connection;

/**
 * @author Rich_fu
 * @date 2021/3/22
 */
public class POP3Connection implements Connection{
    @Override
    public void getConnection() {
        System.out.println("获取POP3 协议的连接");
    }
}
