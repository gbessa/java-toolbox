package br.com.hoptech.java8.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamFunctions {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10, 10);

        /**
         * Operações Intermediárias (retornam nova Stream)
         *
         * SKIP (pula a posição passada)
         * DISTINCT (elimina duplicados - usa equals)
         * FILTER (Predicate - return boolean)
         * MAP (Function - return generics)
         * LIMIT (limita a quantidade de elementos processados)
         * ...
         */
        System.out.println("Operações Intermediárias");
        list.stream()
                .skip(4)
                .distinct()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 10)
                .limit(3)
                .forEach(System.out::println);

        /**
         * Operações Finais (finalizam a Stream)
         *
         * FOREACH (Consumer - return void)
         * COUNT
         * MIN
         * MAX
         * COLLECT
         * ...
         */
        System.out.println("Operações Finais");
        System.out.println(list.stream().count());
        System.out.println(list.stream().min(Comparator.naturalOrder()).get());
        System.out.println(list.stream().max(Comparator.naturalOrder()).get());
        List<Integer> newList = list.stream().limit(3).collect(Collectors.toList());
        System.out.println(newList);


        /**
         * Collectors
         *
         * toList
         * groupingBy (a chave do mapa será o retorno da Function passada para o groupingBy)
         * joining (concatena em uma String, evita o uso do StringBuilder)
         * ...
         */
        System.out.println("Colectors");

        List<Integer> collectedList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);

        Map<String, List<Integer>> groupedByOddOrEven = list.stream().distinct().collect(Collectors.groupingBy(e -> e % 2 == 0 ? "EVEN" : "ODD"));
        System.out.println(groupedByOddOrEven);

        String joinned = list.stream().map(String::valueOf).collect(Collectors.joining("-"));
        System.out.println(joinned);

    }
}
