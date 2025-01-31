package com.mycompany.data;

import java.util.Scanner;
import java.sql.*;
import com.mycompany.main.Main;

public class CheckBalance {

    public void checkBalance() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "Mysql@123");

//          Getting account details
            PreparedStatement ps = cn.prepareStatement("Select * from Holder where account_no = ? and pin = ?");
            ps.setInt(1, Main.account);
            ps.setString(2, Main.pin);

            System.out.println("");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Main.name = rs.getString("Name");
                Main.balance = rs.getFloat("Balance");

//              Showing Account Details
                System.out.println("Name -> " + Main.name);
                System.out.println("Account Number -> " + Main.account);
                System.out.println("Account Balance -> " + Main.balance);

            }
            System.out.println("");

            cn.close();

        } catch (Exception e) {

            System.out.println(e.toString());

        }

    }

}