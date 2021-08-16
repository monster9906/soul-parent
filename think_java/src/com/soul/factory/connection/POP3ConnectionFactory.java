package com.soul.factory.connection;

/**
 * @author Rich_fu
 * @date 2021/3/22
 */
public class POP3ConnectionFactory implements AbstactConnectionFactory{
    @Override
    public Connection getConnection() {
        return new POP3Connection();
    }
}
