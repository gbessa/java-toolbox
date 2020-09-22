package br.com.hoptech.core;

import java.util.Arrays;

public class Loops {

    // Looping through n
    public static void main(String[] args) {

        int n = 10;
        int result;

        // For Loop (Old School)
        result = 0;
        for (int i = 0; i < n; i++) {
            result++;
        }
        System.out.println(result);

        // For-Each
        result = 0;
        for (String a : "1234567890".split("")) {
            result++;
        }
        System.out.println(result);

        // For-Each (w/ Stream)
        result = 0;
        result = Arrays.stream("1234567890".split("")).map(ele->1).reduce(0, (elem, sum) -> sum+elem);
        System.out.println(result);

    }


}
