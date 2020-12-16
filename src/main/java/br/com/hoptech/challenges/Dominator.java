package br.com.hoptech.challenges;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

    public static void main(String[] args) {
        int[] arrayIn = {0, 0, 1, 1};
        System.out.println(new Dominator().run(arrayIn));
    }

    public int run(int[] A) {
        int half = (int) Math.ceil(A.length/2.0);
        Map<Integer, Integer> map = new HashMap<>();
        int position = 0;
        for (int v : A) {
            if (map.containsKey(v)) {
                map.put(v, map.get(v)+1);
            } else {
                map.put(v, 1);
            }
            if (map.get(v) >= half) return position;
            position++;
        }
        return -1;
    }
}
