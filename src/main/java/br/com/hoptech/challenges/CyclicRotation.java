package br.com.hoptech.challenges;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CyclicRotation {

    public static void main(String[] args) {
        int[] arrIn = {3, 8, 9, 7, 6};
        System.out.println(Arrays.toString(new CyclicRotation().run(arrIn, 3)));

        int[] arrIn2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new CyclicRotation().run(arrIn2, 4)));

        int[] arrIn3 = {};
        System.out.println(Arrays.toString(new CyclicRotation().run(arrIn3, 4)));
    }

    public int[] run(int[] A, int K) {
        if (A.length == 0) return A;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            deque.add(A[i]);
        }
        for (int i = 1; i<=K; i++) {
            deque.addFirst(deque.removeLast());
        }
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }
}
