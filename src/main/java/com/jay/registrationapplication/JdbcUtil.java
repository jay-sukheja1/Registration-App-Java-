package com.jay.registrationapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "DATABASE_URL";
        String user = "USERNAME";
        String pass = "PASSWORD";
        return DriverManager.getConnection(url, user, pass);
    }

    public static void closeResources(Connection conn, Statement stmt) throws SQLException {
        if (conn != null){
            conn.close();
        }
        if (stmt != null){
            stmt.close();
        }
    }
}
