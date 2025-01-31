import java.util.ArrayList;

class Student
{

private int emp_id;
private String emp;
private int salary;

void setEmp_id(int emp_id)
{
this.emp_id=emp_id;
}

void setEmp(String emp)
{
this.emp=emp;
}

void setSalary(int salary)
{
this.salary=salary;
}

int getEmp_id()
{
return emp_id;
}

String getEmp()
{
return emp;
}

int getSalary()
{
return salary;
}

}

class test
{
public static void main(String args[])
{

Student s1=new Student();
s1.setEmp_id(102);
s1.setEmp("Lakshya");
s1.setSalary(800000);

Student s2=new Student();
s2.setEmp_id(101);
s2.setEmp("Praveen");
s2.setSalary(500000);

Student s3=new Student();
s3.setEmp_id(103);
s3.setEmp("Yash");
s3.setSalary(600000);

ArrayList<Student> al = new ArrayList<>();

al.add(s1);
al.add(s2);
al.add(s3);

for(Student s:al)
{
System.out.println(s.getEmp()+" "+s.getEmp_id()+" "+s.getSalary());
}

}
}

