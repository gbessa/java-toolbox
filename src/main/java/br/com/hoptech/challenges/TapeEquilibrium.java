package br.com.hoptech.challenges;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class TapeEquilibrium {

    public static void main(String[] args) {
        int[] arrayIn = {3, 1, 2, 4, 3};
        System.out.println(new TapeEquilibrium().run(arrayIn));
    }

    int run(int[] A) {
        Deque<Integer> deque = new ArrayDeque<>();
        int right = 0;
        for (int v : A) {
            deque.add(v);
            right += v;
        }
        int min = Integer.MAX_VALUE;
        int left = 0;

        while (deque.size() >= 2) {
            int lefter = deque.removeFirst();
            left += lefter;
            right -= lefter;
            min = Math.min(min, Math.abs(left-right));
        }
        return min;
    }
}
