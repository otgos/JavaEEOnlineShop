package com.upper.database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {

    Connection conn = null;

    public static Connection ConnectDB() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //register jdbc driver
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/upperelectronics?useUnicode=true&serverTimezone=UTC", "root", "sece2015");
            // JOptionPane.showMessageDialog(null, "Connected to db");
            return conn;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }


}
