/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import com.mycompany.employee.Employee;
import com.mycompany.sort.SortById;
import com.mycompany.sort.SortByName;
import com.mycompany.sort.SortBySalary;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author administrator
 */
public class Test {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setId(102);
        e1.setName("Ramlal");
        e1.setSalary(300.0);

        Employee e2 = new Employee();
        e2.setId(101);
        e2.setName("Shamlal");
        e2.setSalary(100.0);

        Employee e3 = new Employee();
        e3.setId(103);
        e3.setName("Babulal");
        e3.setSalary(200.0);

        ArrayList<Employee> al = new ArrayList<>();
        al.add(e1);
        al.add(e2);
        al.add(e3);
        Iterator itr = al.iterator();

        while (itr.hasNext()) {
            Employee e = (Employee) itr.next();
            System.out.println(e.getId() + ":" + e.getName() + ":" + e.getSalary());
        }

        System.out.println("After sorting by ID=");

        Collections.sort(al, new SortById());
        Iterator<Employee> itr2 = al.iterator();

        while (itr2.hasNext()) {
            Employee e = itr2.next();
            System.out.println(e.getId() + ":" + e.getName() + ":" + e.getSalary());
        }
        System.out.println("After sorting by name=");

        Collections.sort(al, new SortByName());
        Iterator<Employee> itr3 = al.iterator();

        while (itr3.hasNext()) {
            Employee e = itr3.next();
            System.out.println(e.getId() + ":" + e.getName() + ":" + e.getSalary());
        }

        System.out.println("After sorting by salary=");

        Collections.sort(al, new SortBySalary());
        Iterator<Employee> itr4 = al.iterator();

        while (itr4.hasNext()) {
            Employee e = itr4.next();
            System.out.println(e.getId() + ":" + e.getName() + ":" + e.getSalary());
        }
    }

}
