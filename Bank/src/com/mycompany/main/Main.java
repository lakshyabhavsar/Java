package com.mycompany.main;

import com.mycompany.data.*;
import java.util.Scanner;
import java.sql.*;

public class Main {

    public static Integer account;
    public static String pin;
    public static String name;
    public static Float balance;

    public static void main(String[] args) {

//      Taking account_no and pin from user
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Account Number -> ");
        Main.account = sc.nextInt();

        System.out.println("Enter Pin -> ");
        Main.pin = sc.next();

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

                System.out.println("Wlecome " + Main.name);
            }
            System.out.println("");

//          Giving options to user
            int x = 0;
            while (x == 0) {

                System.out.println("Press 1 to Check Balance ");
                System.out.println("Press 2 to Cash Deposit ");
                System.out.println("Press 3 to Cash Withdrawl ");
                System.out.println("Press 4 to Exit ");

                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        CheckBalance cb = new CheckBalance();
                        cb.checkBalance();
                        break;

                    case 2:

                        Deposit d = new Deposit();
                        d.deposit();

                        break;

                    case 3:

                        Withdraw w = new Withdraw();
                        w.withdraw();

                        break;

                    case 4:
                        x = 1;
                        break;

                    default:
                        System.out.println("Invalid Choice...!");
                        break;
                }
            }
            cn.close();
            System.out.println("Thank You for visiting");

        } catch (Exception e) {

            System.out.println(e.toString());

        }

    }

}
