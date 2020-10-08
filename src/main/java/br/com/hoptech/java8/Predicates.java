package br.com.hoptech.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Predicates {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        System.out.println("Pred 01");
        printFiltered(numbers, (x)->x>3);
        System.out.println("Pred 02");
        printFiltered(numbers, (x)->x%2==0);
        System.out.println("Pred 03");
        printFiltered(numbers, (x) -> fncCondition(x));
    }

    static boolean fncCondition(Integer x) {
        return x==5;
    }

    private static void printFiltered(List<Integer> values, Predicate<Integer> condition) {
        for (Integer value : values) {
            if (condition.test(value)) {
                System.out.println(value);
            }
        }
    }

}
