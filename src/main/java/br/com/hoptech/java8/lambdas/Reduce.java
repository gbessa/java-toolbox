package br.com.hoptech.java8.lambdas;

import java.util.Arrays;
import java.util.List;

public class Reduce {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10, 10);

        /** Reduce com Accumulator (retorna um Optional de Integer)
         *  A cada loop ele acumula o resultado no n1 e bota o próximo elemento no n2
         *  n1 = acc e n2 = next
         *  Enfim, a ideia do reduce é pegar todos os elementos do Stream e transformar em uma coisa só
         */
        list.stream()
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);

        // Reduce com Valor inicial (identity), não precisa mais retrornar Optional
        Integer result = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(result);

        // Reduce para concatenar Strings
        list.stream()
                .map(String::valueOf)
                .reduce((n1, n2) -> n1.concat(n2))
                .ifPresent(System.out::println);

        // Reduce para concatenar Strings com Identiy
        String strResult = list.stream()
                .map(String::valueOf)
                .reduce("Result: ", (n1, n2) -> n1.concat(n2));
        System.out.println(strResult);
    }
}
