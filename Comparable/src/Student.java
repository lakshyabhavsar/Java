
public class Student implements Comparable<Student> {

    private int roll;
    private String name;
    private double percent;

    @Override
    public String toString() {
        return roll + ":" + name + ":" + percent;
    }

    @Override
    public int compareTo(Student s) {

        if (s.roll > this.roll) {
            return -1;
        } else if (s.roll < this.roll) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

}
