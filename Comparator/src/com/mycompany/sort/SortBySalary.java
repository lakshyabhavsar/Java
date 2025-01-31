/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sort;

import com.mycompany.employee.Employee;
import java.util.Comparator;

/**
 *
 * @author administrator
 */
public class SortBySalary implements Comparator<Employee>
{

    @Override
    public int compare(Employee e1, Employee e2) {
        if(e1.getSalary()>e2.getSalary())
        {
            return 1;
        }
        else if(e1.getSalary()<e2.getSalary())
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
    
}
