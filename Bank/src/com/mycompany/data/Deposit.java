package com.mycompany.data;

import com.mycompany.main.Main;
import java.util.Scanner;
import java.sql.*;

public class Deposit {

    public void deposit() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Deposit Amount -> ");
        Float balance = sc.nextFloat();

        System.out.print("Enter Pin -> ");
        String pin = sc.next();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "Mysql@123");

//          Updating details
            if (Main.pin.equals(pin)) {

                Main.balance = Main.balance + balance;

                Statement smt = cn.createStatement();

                int i = smt.executeUpdate("Update Holder set balance = " + Main.balance + "where account_no = " + Main.account);

                if (i > 0) {
                    System.out.println("Withdraw successful amount -> " + balance);

                }

            } else {

                System.out.println("Invalid Pin...!");

            }

            System.out.println("");

            cn.close();

        } catch (Exception e) {

            System.out.println(e.toString());

        }

    }
}
