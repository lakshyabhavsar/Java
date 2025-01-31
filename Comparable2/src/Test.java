
import java.util.ArrayList;
import java.util.Collections;

public class Test {

    public static void main(String[] args) {

        Employee e1 = new Employee();
        e1.setEmp_id(102);
        e1.setName("Lakshya");
        e1.setSalary(90000);

        Employee e2 = new Employee();
        e2.setEmp_id(101);
        e2.setName("Praveen");
        e2.setSalary(12000);

        Employee e3 = new Employee();
        e3.setEmp_id(103);
        e3.setName("Yash");
        e3.setSalary(36000);

        ArrayList<Employee> al = new ArrayList<>();
        al.add(e1);
        al.add(e2);
        al.add(e3);

        for (Employee e : al) {
            System.out.println(e);
        }

        System.out.println("After Sorting Employee ID ->");

        Collections.sort(al);

        for (Employee e : al) {
            System.out.println(e);
        }
    }
}
