package br.com.hoptech.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class TiposDeColecao {

    /**
     *  List inteface
     *  - ArrayList
     *  - LinkedList
     *
     *
     *  Set Interface - Ser repetição, pois usa o hash
     *  - HashSet (ordenado)
     *
     *
     *  Queue Interface
     *  - Deque Interface
     *    - ArrayDeque
     */

    public static void main(String[] args) {

        //DEQUE - Fila com 2 pontas
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(3);deque.add(2);deque.add(1);deque.removeFirst();deque.pollLast();
        System.out.println(deque);

        //HASHSET - Set (SEM repetição) e já entra ORDENADO
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(3);hashSet.add(3);hashSet.add(1);hashSet.add(2);hashSet.add(4);
        System.out.println(hashSet);


    }


}
