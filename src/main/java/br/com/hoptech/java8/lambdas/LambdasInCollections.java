package br.com.hoptech.java8.lambdas;

import java.util.*;

/**
 * Métodos das Collections que recebem Lambdas
 *
 * - forEach
 * - removeIf
 * - replaceAll
 * - compute
 * - merge
 *
 */
public class LambdasInCollections {

    public static void main(String[] args) {

        /**
         * with Lists
         */
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);

        list.forEach(System.out::println);

        list.removeIf(n -> n%2==0);
        list.forEach(System.out::println);

        list.replaceAll(n -> n*10);
        list.forEach(System.out::println);

        /**
         * with Maps
         */
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A"); map.put(2, "B"); map.put(3, "C"); map.put(4, "D"); map.put(5, "E");

        map.forEach((k, v) -> System.out.println(k + " - " + v));

        map.compute(1, (k, v) -> "[" + v + "]");
        map.forEach((k, v) -> System.out.println(k + " - " + v));
    }

}
