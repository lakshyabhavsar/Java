package CarSpeed;

import java.util.Scanner;

class CarSpeed
{
public static void main(String arg[])
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter Your Speed -> ");
int speed=sc.nextInt();

try
{
CheckSpeed.check(speed);
}
catch(LowSpeed ls)
{
ls.getMessege();
}
catch(HighSpeed hs)
{
hs.getMessege();
}
finally
{
System.out.println("Thanks for coming");
}
}
}