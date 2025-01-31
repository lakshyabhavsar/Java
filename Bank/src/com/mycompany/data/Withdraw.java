package com.mycompany.data;

import com.mycompany.main.Main;
import java.util.Scanner;
import java.sql.*;

public class Withdraw {

    public void withdraw() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Withdraw Amount -> ");
        Float new_balance = sc.nextFloat();

        System.out.print("Enter Pin -> ");
        String pin = sc.next();
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "Mysql@123");

            if (Main.pin.equals(pin)) {

                Main.balance = Main.balance - new_balance;

                Statement smt = cn.createStatement();

                int i = smt.executeUpdate("Update Holder set balance = " + Main.balance + "where account_no = " + Main.account);

                if (i > 0) {
                    System.out.println("Withdraw successful amount -> " + new_balance);

                }

            } else {

                System.out.println("Invalid Pin...!");

            }

        } catch (Exception e) {

            System.out.println(e.toString());

        }
    }
}
