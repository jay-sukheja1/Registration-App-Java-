package com.jay.registrationapplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
    private String name;
    private String mail;
    private String pass;
    private String city;
    private Connection connect = null;
    private PreparedStatement prstmt = null;
    private Integer row = 0;
    private ResultSet rs = null;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer register(){
        try {
            connect = JdbcUtil.getConnection();
            String sql = "insert into java_db.personalinfo (name, email, upassword, city) values(?,?,?,?)";
            prstmt = connect.prepareStatement(sql);
            prstmt.setString(1, name);
            prstmt.setString(2, mail);
            prstmt.setString(3, pass);
            prstmt.setString(4, city);

            row = prstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcUtil.closeResources(connect, prstmt);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return row;
    }

    public ResultSet login(){
        try {
            connect = JdbcUtil.getConnection();
            String sql = "select * from java_db.personalinfo where name = ? and upassword = ?";
            prstmt = connect.prepareStatement(sql);
            prstmt.setString(1, name);
            prstmt.setString(2, pass);

            rs = prstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                JdbcUtil.closeResources(connect, prstmt);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rs;
    }

}
