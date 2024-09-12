package br.com.hoptech.hrank;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagramSlow("bola", "balo"));
        System.out.println(isAnagramSlow("bolacavaloteste", "balovacaloestte"));
        System.out.println(isAnagramSlow("balacavaloteste", "balovacaloestte"));
    }

    /// O(n^2)
    public static boolean isAnagramSlow(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> sHash = new HashMap<>();
        HashMap<Character, Integer> tHash = new HashMap<>();
        for (int i=0; i < s.length(); i++) {
            sHash.put(s.charAt(i), 0);
            tHash.put(s.charAt(i), 0);
        }

        for (int i=0; i < s.length(); i++) {
            if (sHash.containsKey(s.charAt(i))) {
                sHash.replace(s.charAt(i), sHash.get(s.charAt(i)) + 1);
            }

            if (tHash.containsKey(s.charAt(i))) {
                tHash.replace(s.charAt(i), tHash.get(s.charAt(i)) + 1);
            }
        }

        if (sHash.size() != tHash.size()) return false;

        AtomicBoolean result = new AtomicBoolean(true);

        sHash.forEach( (k, v) -> {
          if (tHash.containsKey(k) && tHash.get(k) == v) {

          } else {
              result.set(false);
          }
        });

        return result.get();
    }
}
