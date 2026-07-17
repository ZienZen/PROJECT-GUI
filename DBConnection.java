package com.example.prodjects_gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static final String URL = "jdbc:mysql://localhost:3306/db.learningsystem";
    public static final String USER = "root";
    public static final String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to database successfully");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("Need to include java.sql in the library and module info");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        getConnection();
    }
}