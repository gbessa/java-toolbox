package br.com.hoptech.algorithms.sorting;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        // given
        Sorter sorter = new BubbleSort();
        int[] arrayToSort = {3, 2, 4, 9, 4, 4, 4, 1, 8, 7, 6, 8, 10, 2, 1, 0, -4};

        // when
        int[] actual = sorter.sort(arrayToSort);
        //Arrays.stream(actual).forEach(System.out::println);
        final int[] EXPECTED = {-4, 0, 1, 1, 2, 2, 3, 4, 4, 4, 4, 6, 7, 8, 8, 9, 10};

        // then
        assertArrayEquals(EXPECTED, actual);

        // ou usamos o AsserThat com os Matchers do Hamcrest para ter uma escrita mais fluente
        assertThat(actual, is(equalTo(EXPECTED)));

    }
}