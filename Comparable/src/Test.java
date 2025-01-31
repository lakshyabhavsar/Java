
import java.util.ArrayList;
import java.util.Collections;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author administrator
 */
public class Test {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setRoll(102);
        s1.setName("Lakshya");
        s1.setPercent(99.98);

        Student s2 = new Student();
        s2.setRoll(101);
        s2.setName("Praveen");
        s2.setPercent(12.6);

        Student s3 = new Student();
        s3.setRoll(103);
        s3.setName("Yash");
        s3.setPercent(36.8);

        ArrayList<Student> al = new ArrayList<>();
        al.add(s1);
        al.add(s2);
        al.add(s3);

        for (Student s : al) {
            System.out.println(s);
        }

        System.out.println("After Sorting Roll no ->");

        Collections.sort(al);

        for (Student s : al) {
            System.out.println(s);
        }
    }

}
