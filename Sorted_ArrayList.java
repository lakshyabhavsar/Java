import java.util.ArrayList;
import java.util.Collections;

class Sorted_ArrayList
{

public static void main(String args[])
{

ArrayList<String> al = new ArrayList<>();

al.add("Lakshya");
al.add("Yash");
al.add("Praveen");
al.add("Punit");
al.add("Vivek");

System.out.print("Unsorted List -> ");
System.out.println(al);

System.out.print("Sorted List -> ");
Collections.sort(al);
System.out.println(al);

}
}
