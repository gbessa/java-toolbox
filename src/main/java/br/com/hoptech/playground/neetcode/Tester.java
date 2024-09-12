package br.com.hoptech.playground.neetcode;

import lombok.var;

public class Tester {
    public static void main(String[] args) {
        var lista = new LinkedList();

        lista.insertHead(2);
        lista.insertTail(3);
        lista.insertHead(1);
        lista.insertTail(4);

        System.out.println("Gets");
        System.out.println(lista.get(0));
        System.out.println(lista.get(1));
        System.out.println(lista.get(2));
        System.out.println(lista.get(3));

        lista.remove(0);

        System.out.println("Get Values");
        lista.getValues().forEach(System.out::print);

        System.out.println("\nGet Values");
        lista.remove(2);
        lista.getValues().forEach(System.out::print);
    }
}
