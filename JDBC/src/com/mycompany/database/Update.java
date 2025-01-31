package com.mycompany.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Update {

    public void updateName() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter New Name -> ");
        String name = sc.next();

        System.out.print("Enter Roll Number where you want to update Name -> ");
        Integer roll = sc.nextInt();

        try {

            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create the connection
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/College", "root", "Mysql@123");

            Statement smt = cn.createStatement();

            int i = smt.executeUpdate("update Student set name = '" + name + "' where Roll_No = " + roll);

            if (i > 0) {
                System.out.println("Data Updated");
                System.out.println("");
            }
            cn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void updatePercent() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter New Percent -> ");
        String percent = sc.next();

        System.out.print("Enter Roll Number where you want to update Percent -> ");
        Integer roll = sc.nextInt();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/College", "root", "Mysql@123");

            Statement smt = cn.createStatement();

            int i = smt.executeUpdate("update Student set percent = '" + percent + "' where Roll_No = " + roll);

            if (i > 0) {
                System.out.println("");
                System.out.println("Data Updated");
            }
            cn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}