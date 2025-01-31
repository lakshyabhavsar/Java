abstract class doo
{

void m()
{
System.out.println("This is a Normal Method in abstract class.");
}

abstract void n();

}

class New2
{

public static void main(String arg[])
{

new doo(){

void n()
{
System.out.println("This is Abstract class");
}
}.n();

}
}