package com.mycompany.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ShowDatabase {

    public void showDatabase() {
        try {

            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/College", "root", "Mysql@123");

            Statement smt = cn.createStatement();

            ResultSet rs = smt.executeQuery("select * from Student");

            System.out.println("");
            while (rs.next()) {
                Integer roll = rs.getInt("Roll_No");
                String name = rs.getString("Name");
                Float percent = rs.getFloat("Percent");

                System.out.println(roll + " " + name + " " + percent);
            }
            System.out.println("");

            cn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}