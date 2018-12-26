package com.travis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTImezone=UTC";
        String user = "root";
        String password = "Weeqwe123";
        try {
            Connection con = DriverManager.getConnection(jdbcUrl, user, password);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
