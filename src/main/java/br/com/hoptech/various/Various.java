package br.com.hoptech.various;

public class Various {

    public static void main(String[] args) {

        divisionByZeroBehavior();
        incrementersBehavior();

    }

    /**
     * Division by zero Behavior
     */
    public static void divisionByZeroBehavior() {
        System.out.println("### Division by zero");
        int a = 1;
        double b = 1;
        try {
            System.out.println(a/0);
        } catch (ArithmeticException e) {
            System.out.println("Lançou ArithmeticException");
        }
        System.out.println(b/0);
    }

    /**
     * Incrementers Behavior
     */
    public static void incrementersBehavior() {
        System.out.println("### Incrementer");
        int c = 10; int d = 10;
        System.out.println(c++);
        System.out.println(++d);
        int x = 3; int y = 5; int z = 10;
        int result = ++z + y - y + z + x++;
        System.out.println(result);
    }

}
