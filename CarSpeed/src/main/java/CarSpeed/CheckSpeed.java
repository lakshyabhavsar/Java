package CarSpeed;

class CheckSpeed
{
static void check(int speed)throws HighSpeed, LowSpeed
{
if(speed>100)
{
HighSpeed hs=new HighSpeed();
throw hs;
}
else if(speed<60)
{
LowSpeed ls=new LowSpeed();
throw ls;
}
else
{
System.out.println("Your Speed is Normal");
}
}
}