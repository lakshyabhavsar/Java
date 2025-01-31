abstract class Animal
{

    abstract void animalSound();
    void normalMethod()
    {
    
        System.out.println("This is a normal method");
    
    }
}


class Dog extends Animal
{
    void animalSound()
    {
    
        System.out.println("This is an Abstract method");
                
    
    }
}

class Abstractclass
{

        public static void main(String[] args)
        {
             Dog d = new Dog();
             
             d.animalSound();
             d.normalMethod();
        }

}