package com.mycompany.main;

import com.mycompany.database.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Integer w = 0;
        while (w == 0) {
            System.out.println("Enter 1 to Insert data");
            System.out.println("Enter 2 to Update data");
            System.out.println("Enter 3 to Show Data");
            System.out.println("Enter 4 to Exit");

            System.out.print("Enter your choice -> ");
            Scanner sc = new Scanner(System.in);
            Integer ch = sc.nextInt();

            switch (ch) {
                case 1:
                    Insert i = new Insert();
                    i.insert();
                    break;

                case 2:
                    Update u = new Update();
                    System.out.println("Enter 1 to Update Name");
                    System.out.println("Enter 2 to Update Percent");
                    System.out.println("Enter 3 to Exit");

                    System.out.print("Enter your choice -> ");
                    Integer ch2 = sc.nextInt();

                    switch (ch2) {
                        case 1:
                            u.updateName();
                            break;

                        case 2:
                            u.updatePercent();
                            break;

                        case 3:
                            System.out.println("");
                            break;

                        default:
                            System.out.println("Invalid choice...!");
                    }
                    break;

                case 3:
                    ShowDatabase sd = new ShowDatabase();
                    sd.showDatabase();
                    break;

                case 4:
                    w = 1;
                    break;

                default:
                    System.out.println("Invalid choice...!");
            }
        }
    }
}