package br.com.hoptech.exceptions;

import java.io.IOException;

public class Exceptions {
    public static void main(String[] args) {
        System.out.println(Calculator.div(4,2));


        try {
            System.out.println(Calculator.div(4,0));

            // Various Catches (From most specific to the most general)
        } catch (ArrayIndexOutOfBoundsException e) {

        } catch (ArithmeticException e) {
            System.out.println("Caught you!!");

        } catch (Exception e) {

        } finally {
            System.out.println("Always run finally");
        }
    }

}

class Calculator {
    static double div(int a, int b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("O dividendo não pode ser Zero");
        return a/b;
    }
}
