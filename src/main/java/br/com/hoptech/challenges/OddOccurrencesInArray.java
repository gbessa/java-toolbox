package br.com.hoptech.challenges;


import java.util.ArrayList;
import java.util.Collections;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        int[] arrayIn = {2, 2, 4, 4, 4, 5, 4};
        System.out.println(new OddOccurrencesInArray().run(arrayIn));
    }

    int run(int[] A) {
        if (A.length == 1) return A[0];
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int a : A) {
            lista.add(a);
        }
        Collections.sort(lista);
        for (int i=0; i<lista.size(); i++) {
            if (i == lista.size()-1) return lista.get(i);
            if (lista.get(i).equals(lista.get(i+1)))
                i++;
            else
                return lista.get(i);
        }
        return 0;
    }

}
