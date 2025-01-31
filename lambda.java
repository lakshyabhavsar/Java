@FunctionalInterface
interface I 
{
    void show(int a);
}

class lambda {

    public static void main(String[] args) 
    {
	I i = (int a) -> 
            {
		System.out.println("Hello This is 'show()' method of 'Interface I' ");
		System.out.println(a);

            };

	i.show(5);
    }

}
