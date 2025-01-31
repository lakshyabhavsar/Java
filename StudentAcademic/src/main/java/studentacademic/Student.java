
package studentacademic;

import java.util.Scanner;

class Student	
{
private int roll;
private String name;
private String email;

class Academic
{

int p,c,m;

void get()
{

Scanner s=new Scanner(System.in);

System.out.print("Enter Your Name -> ");
name = s.nextLine();
System.out.println();
System.out.print("Enter Your Roll No. -> ");
roll = s.nextInt();
System.out.println();
System.out.print("Enter Your Email -> ");
email = s.next();
System.out.println();
System.out.print("Enter Your Physics Marks -> ");
p = s.nextInt();
System.out.println();
System.out.print("Enter Your Chemistry Marks -> ");
c = s.nextInt();
System.out.println();
System.out.print("Enter Your Maths Marks -> ");
m = s.nextInt();
System.out.println();

}

void put()
{

System.out.println("Name -> "+name);
System.out.println("Roll No. -> "+roll);
System.out.println("Email -> "+email);
System.out.println("Physics Marks -> "+p);
System.out.println("Chemistry Marks -> "+c);
System.out.println("Maths Marks -> "+m);

}
}
}
