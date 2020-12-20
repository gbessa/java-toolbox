package br.com.hoptech.challenges;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public static void main(String[] args) {

        //int[] arrayIn = {1, 3, 6, 4, 1, 2};
        int[] arrayIn = {-1, -3};
        System.out.println(new MissingInteger().run(arrayIn));

    }

    public int run(int[] A) {
        Set<Integer> hashSet = new HashSet<>();
        int bestNumber = 1;
        for (int a : A) {
            hashSet.add(a);
        }
        for (int v : hashSet) {
            if (v == bestNumber) bestNumber++;
        }
        return bestNumber;

    }

}
