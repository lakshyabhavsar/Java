package com.mycompany.main;

import com.mycompany.student.Student;
import com.mycompany.sort.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setRoll(102);
        s1.setName("Chaganlal");
        s1.setPercent(82.9);

        Student s2 = new Student();
        s2.setRoll(101);
        s2.setName("Madanlal");
        s2.setPercent(47.2);

        Student s3 = new Student();
        s3.setRoll(103);
        s3.setName("Jethalal");
        s3.setPercent(62.5);

        ArrayList<Student> al = new ArrayList<>();
        al.add(s1);
        al.add(s2);
        al.add(s3);

        Iterator<Student> itr = al.iterator();

        while (itr.hasNext()) {
            Student s = (Student) itr.next();
            System.out.println(s.getRoll() + ":" + s.getName() + ":" + s.getPercent());
        }

        System.out.println();
        System.out.println("After Sorting by Roll Number -> ");

        Collections.sort(al, new SortByRoll());

        Iterator<Student> itr2 = al.iterator();

        while (itr2.hasNext()) {
            Student s = itr2.next();
            System.out.println(s.getRoll() + ":" + s.getName() + ":" + s.getPercent());
        }

        System.out.println();
        System.out.println("After Sorting by Name -> ");

        Collections.sort(al, new SortByName());

        Iterator<Student> itr3 = al.iterator();

        while (itr3.hasNext()) {
            Student s = itr3.next();
            System.out.println(s.getRoll() + ":" + s.getName() + ":" + s.getPercent());
        }

        System.out.println();
        System.out.println("After Sorting by Percentage -> ");

        Collections.sort(al, new SortByPercent());

        Iterator<Student> itr4 = al.iterator();

        while (itr4.hasNext()) {
            Student s = itr4.next();
            System.out.println(s.getRoll() + ":" + s.getName() + ":" + s.getPercent());
        }

    }
}
