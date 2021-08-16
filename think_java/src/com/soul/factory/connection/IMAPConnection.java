package com.soul.factory.connection;

/**
 * @author Rich_fu
 * @date 2021/3/22
 */
public class IMAPConnection implements Connection{
    @Override
    public void getConnection() {
        System.out.println("获取IMAP协议的连接");
    }
}
