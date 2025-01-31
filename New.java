interface I
{
int m(int a,int b);
}

class New
{
public static void main(String arg[])
{

I i=(a,b)->
{
return a+b;
};

int c=i.m(10,20);
System.out.println("Value -> "+c);
}
}