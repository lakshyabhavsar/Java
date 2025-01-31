
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayList {

    public static void main(String args[]) {
        // TODO code application logic here
        ArrayList<String> al = new ArrayList<>();
        Scanner s = new Scanner(System.in);

        System.out.println("enter new in list");
        String x = s.nextLine();
        
        al.add(x);
    }
}
