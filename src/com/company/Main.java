package com.company;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static final String userBD = "petroz";
    public static final String passwordBD = "198719pv";
    public static final String urlBD = "jdbc:mysql://mysql.petroz.myjino.ru/petroz";
    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(urlBD,userBD,passwordBD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while(rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("ERROR BD STEP 1 " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("ERROR BD " + e);
            }
        }
    }
}

