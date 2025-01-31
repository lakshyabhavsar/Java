@FunctionalInterface
interface I {

    void show();
}

public class anonymous {

    public static void main(String[] args) {
        I i = new I()
            {
                public void show()
                {
                System.out.println("This is 'anonymous child class' of Parent 'Interface I' ");
                }
            };

        i.show();
    }

}
