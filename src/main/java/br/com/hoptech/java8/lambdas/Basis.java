package br.com.hoptech.java8.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * Para podermos trabalhar como paradigma funcional no JAVA. Como a passagem de funções como parâmetro,
 * foi criado no java 8 as funções lambda, que são na verdade Interfaces Funcionais que seguem o critério
 * SAM (Single Abstract Method)
 * Desta forma, passamos a passar funções como parâmetro e assim fazer uso da API de Streams (fluxo de dados),
 * que é a base de grande parte da programação funcional com os foreach, map, filter, reduce, etc...
 * Anotar uma classe como o @FunctionalIterface é opcional, mas ajuda a documentar e restringir nossas intefaces
 */
public class Basis {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("line 1");
        list.add("line 2");
        list.add("line 3");
        list.add("line 4");
        list.add("line 5");
        list.add("line 6");

        printInJava4(list);
        printInJava5(list);
        printInJava8(list);
        printInJava8MF(list);

    }

    public static void printInJava4(List<String> list) {
        for (int i = 0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void printInJava5(List<String> list) {
        for (String value : list) {
            System.out.println(value);
        }
    }

    public static void printInJava8(List<String> list) {
        list.stream().forEach(
            (value) -> System.out.println(value)
        );
    }

    public static void printInJava8MF(List<String> list) {
        list.forEach(System.out::println);
    }
}
