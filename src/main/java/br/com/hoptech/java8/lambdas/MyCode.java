package br.com.hoptech.java8.lambdas;

import java.util.Arrays;
import java.util.Optional;

class MyCode {

    public static int sumOfEvenNumbers(String[] args) {
        Optional.ofNullable(args).orElseThrow(IllegalArgumentException::new);

        return Arrays.stream(args)
                .map(Integer::valueOf)
                .filter(v -> v%2==0)
                .reduce(0, Integer::sum);
    }

}
