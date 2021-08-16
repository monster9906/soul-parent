package com.soul.factory.connection;

import javafx.scene.control.SpinnerValueFactory;

/**
 * @author Rich_fu
 * @date 2021/3/23
 */
public class Test {
    public static void main(String[] args) {
        POP3ConnectionFactory pop3ConnectionFactory = new POP3ConnectionFactory();
        Connection connection = pop3ConnectionFactory.getConnection();
        connection.getConnection();

        IMAPConnectionFactory imapConnectionFactory = new IMAPConnectionFactory();
        Connection connection1 = imapConnectionFactory.getConnection();
        connection1.getConnection();

        HttpConnectionFactory httpConnectionFactory = new HttpConnectionFactory();
        Connection connection2 = httpConnectionFactory.getConnection();
        connection2.getConnection();

    }
}
