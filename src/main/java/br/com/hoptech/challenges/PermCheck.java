package br.com.hoptech.challenges;

import java.util.HashSet;
import java.util.Set;

public class PermCheck {

    public static void main(String[] args) {

        int[] arrayIn = {9, 5, 7, 3, 2, 7, 3, 1, 10, 8};
        System.out.println(new PermCheck().run(arrayIn));

    }

   public int run(int[] A) {

        Set<Integer> seq = new HashSet<>();

        int max = 0;
        for (int a : A) {
            seq.add(a);
           if (a > max) max = a;
        }

        return (max == A.length && max == seq.size()) ? 1 : 0;
    }

}
