package com.mycompany.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {

    public void insert() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll No -> ");
        Integer roll = sc.nextInt();

        System.out.print("Enter Name -> ");
        String name = sc.next();

        System.out.print("Enter Percentage -> ");
        Float percent = sc.nextFloat();

        try {

            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create the connection
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/College", "root", "Mysql@123");

            PreparedStatement ps = cn.prepareStatement("insert into Student values(?,?,?)");
            ps.setInt(1, roll);
            ps.setString(2, name);
            ps.setFloat(3, percent);

            boolean b = ps.execute();

            if (b == false) {
                System.out.println("");
                System.out.println("Data Inserted");
            }
            cn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
