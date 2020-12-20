package br.com.hoptech.java8.lambdas;

import java.util.stream.IntStream;

public class Various {

    public static void main(String[] args) {

        /**
         * Criando uma sequência
         * */
        IntStream.range(1, 20).forEach(System.out::println);
    }
}
