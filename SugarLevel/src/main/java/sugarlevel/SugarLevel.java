package sugarlevel;
import java.util.Scanner;

class SugarLevel
{
public static void main(String arg[])
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter sugar level -> ");
int l=sc.nextInt();

try
{
CheckSugar.check(l);
}
catch(LowSugar ls)
{
ls.getMessege();
}
catch(HighSugar hs)
{
hs.getMessege();
}
finally
{
System.out.println("Thanks for coming");
}
}
}