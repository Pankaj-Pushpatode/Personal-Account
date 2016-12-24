package com.yash.jdbc.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyShow {

    public void Show() throws IOException {
        Properties pro = new Properties();
        InputStream in = getClass().getResourceAsStream("Message.properties");
        pro.load(in);
        String userName = pro.getProperty("username");
        String password = pro.getProperty("password");
        String driver = pro.getProperty("drivername");
        String url = pro.getProperty("url");
        System.out.println("MySql UserName is :" + userName);
        System.out.println("MySql Password is :" + password);
        System.out.println("MySql Driver Name :" + driver);
        System.out.println("MySql url is :" + url);
    }

    public static void main(String[] args) {
        PropertyShow p = new PropertyShow();
        try {
            p.Show();
        } catch (Exception e) {
        }
    }
}
