package br.com.hoptech.challenges;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

    public static void main(String[] args) {
        int[] arrayIn = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(new FrogRiverOne().run(5, arrayIn));
    }

    int run(int X, int[] A) {
        Set<Integer> lista = new HashSet<>();
        int moment = 0;
        for (int v : A) {
            lista.add(v);
            if (lista.size() == X) return moment;
            moment++;
        }
        return -1;
    }
}
