package br.com.hoptech.tests.tdd;

public class Calculator {

    /**
     * Soma 2 valores inteiros
     * @param a
     * @param b
     */
    public int sum(int a, int b) {
        return a+b;
    }

    static String calcType() {
        return "Calculate with Integers";
    }

    public int sub(int a, int b) {
        return a-b;
    }

    public int mult(int a, int b) {
        return a*b;
    }

    public int div(int a, int b) {
        return a/b;
    }
}
