package com.example.prodjects_gui;

import java.sql.Connection;

public class TestDB {public static void main(String[] args) {

    Connection conn = DBConnection.getConnection();

    if (conn != null) {
        System.out.println("Connected!");
    } else {
        System.out.println("Failed!");
    }

}
}
