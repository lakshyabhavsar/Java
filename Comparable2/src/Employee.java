
public class Employee implements Comparable<Employee> {

    private int emp_id;
    private String name;
    private int salary;

    @Override
    public String toString() {
        return emp_id + ":" + name + ":" + salary;
    }

    @Override
    public int compareTo(Employee e) {

        if (e.emp_id > this.emp_id) {
            return -1;
        } else if (e.emp_id < this.emp_id) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
