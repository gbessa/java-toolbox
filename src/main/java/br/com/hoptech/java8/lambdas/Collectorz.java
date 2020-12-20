package br.com.hoptech.java8.lambdas;

import java.util.*;
import java.util.stream.Collectors;

/**
 * O Reduce é usado para trabalha com variávei imutáveis
 * Para trabalharmos com variáveis mutáveis usamos o stream.collect
 * Exemplo, para concatenar valores do stream em uma lista
 *
 * Já existem vários coletores implementados na Classe Collectors
 *
 * - toList
 * - toCollection
 * - joining
 * - averagingInt
 * - summingInt
 * - summarizingInt
 * - counting
 * - maxBy
 * - groupingBy
 * - toMap
 */
public class Collectorz {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 2, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10, 1);

        /**
         * toList
         */
        System.out.println(list.stream()
                .distinct()
                .collect(Collectors.toList()));

        /**
         * toCollection
         *  para escolhermos o tipo de collection de resultado
         */
        System.out.println(list.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<Integer>())));

        /**
         * joining
         *  para concatenar strings
         *  Internamente ele usa o StringBuilder, que é muito mais performático que o concat no Reduce,
         *  já que não precisar criar vários objetos Strings em cada operação
         */
        System.out.println(list.stream()
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining()));

        /**
         * averagingInt
         */
        System.out.println(list.stream()
                .distinct()
                .collect(Collectors.averagingInt(Integer::intValue)));

        /**
         * summingInt
         */
        System.out.println(list.stream()
                .distinct()
                .collect(Collectors.summingInt(Integer::intValue)));

        /**
         * summarizingInt
         */
        IntSummaryStatistics status = list.stream()
                .distinct()
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.printf("- Min: %d\n- Max: %d\n- Average: %f\n- Count: %d\n- Sum: %d\n", status.getMin(), status.getMax(), status.getAverage(), status.getCount(), status.getSum());

        /**
         * counting
         */
        System.out.println(list.stream()
                .collect(Collectors.counting()));

        /**
         * maxBy
         */
        System.out.println(list.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder())));

        /**
         * groupingBy (retorna um Map, passao a função que define a Key)
         */
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(n -> n%2==0)));

        /**
         * toMap (retorna um Map tb, mas nesse posso definição da Key e do Value)
         */
        System.out.println(list.stream()
                .distinct()
                .collect(Collectors.toMap(n -> n, n -> n%2==0)));
    }
}
