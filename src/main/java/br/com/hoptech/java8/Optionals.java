package br.com.hoptech.java8;

import java.security.InvalidParameterException;
import java.util.Optional;
import java.util.OptionalInt;

public class Optionals {

    public static void main(String[] args) {

        int x = 1;

        // Criando Optionals
        Optional<Integer> op1 = Optional.of(x);
        Optional<Integer> opEmpty = Optional.empty();
        Optional<Integer> opOfNullable = Optional.ofNullable(x);
        System.out.println(op1);
        System.out.println(opEmpty);
        System.out.println(opOfNullable);

        // Usando Optionals
        System.out.println(division(3,4));
        System.out.println(division(3,0));

        System.out.println(division(0,3).get());
        System.out.println(division(3,0).get());
        System.out.println(division(3,0).isPresent());
        System.out.println(opEmpty.isPresent());
        System.out.println(opEmpty.orElse(10));
        System.out.println(opEmpty.orElseGet(() -> heavyOperation()));
        try {
            System.out.println(opEmpty.orElseThrow(InvalidParameterException::new));
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        System.out.println(toInt("3"));
        System.out.println(toInt("3").getAsInt());
        System.out.println(toInt("casa3").orElse(0));
    }

    // Optional com tipos primitivos
    private static OptionalInt toInt(String valueFrom) {
        try {
            int result = Integer.valueOf(valueFrom);
            return OptionalInt.of(result);
        } catch (Exception e) {
            return OptionalInt.empty();
        }
    }

    private static int heavyOperation() {
        return 100000;
    }

    private static Optional<Double> division(double a, double b) {
        try {
            double result = a/b;
            return Optional.of(result);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
