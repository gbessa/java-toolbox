package br.com.hoptech.collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * FAST !!
 */
public class Dequeues {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);

        System.out.println(deque);
        System.out.println(deque.size());
    }
}
