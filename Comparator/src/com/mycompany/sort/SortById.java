/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sort;

import com.mycompany.employee.Employee;
import java.util.Comparator;

public class SortById implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Employee e1 = (Employee) o1;
        Employee e2 = (Employee) o2;

        if (e1.getId() > e2.getId()) {
            return 1;
        } else if (e1.getId() < e2.getId()) {
            return -1;
        } else {
            return 0;
        }
    }

}
