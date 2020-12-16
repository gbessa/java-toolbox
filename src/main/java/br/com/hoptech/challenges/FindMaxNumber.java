package br.com.hoptech.challenges;

import java.util.List;

public class FindMaxNumber {

    public static int findMaxFirstSolution(List<Integer> numbers) {
        int maxNumb = numbers.get(0);
        for (int number : numbers) {
            if (number > maxNumb) maxNumb = number;
        }
        return maxNumb;
    }

    public Integer findMax(List<Integer> numbers) {
        return numbers.stream()
                .reduce((acc, ele) -> acc > ele ? acc : ele)
                .orElseThrow(IllegalArgumentException::new);
    }
}
