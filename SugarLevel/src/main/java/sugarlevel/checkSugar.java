package sugarlevel;
class CheckSugar
{
static void check(int level)throws HighSugar,LowSugar
{
if(level>120)
{
HighSugar hs=new HighSugar();
throw hs;
}
else if(level<70)
{
LowSugar ls=new LowSugar();
throw ls;
}
else
{
System.out.println("You have Normal Sugar Level");
}
}
}