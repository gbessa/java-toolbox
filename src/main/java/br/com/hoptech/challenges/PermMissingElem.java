package br.com.hoptech.challenges;

import java.util.ArrayList;
import java.util.Collections;

public class PermMissingElem {
    public static void main(String[] args) {
        int[] arrayIn = {};
        System.out.println(new PermMissingElem().run(arrayIn));
    }
    int run(int[] A) {
        if (A.length == 0) return 1;
        ArrayList<Integer> lista = new ArrayList<>();
        for (int v : A) lista.add(v);
        Collections.sort(lista);
        if (lista.get(0)>1) return 1;
        for (int i = 0; i < lista.size(); i++) {
            if (i == lista.size()-1) return lista.get(i)+1;
            if ((lista.get(i)+1) != lista.get(i+1)) return lista.get(i)+1;
        }
        return 0;
    }
}
