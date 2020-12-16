package br.com.hoptech.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        // given
        Sorter sorter = new QuickSort();
        int[] arrayToSort = {3, 2, 4, 9, 4, 4, 4, 1, 8, 7, 6, 8, 10, 2, 1, 0, -4};

        // when
        int[] actual = sorter.sort(arrayToSort);
        //Arrays.stream(actual).forEach(System.out::println);
        final int[] EXPECTED = {-4, 0, 1, 1, 2, 2, 3, 4, 4, 4, 4, 6, 7, 8, 8, 9, 10};

        // then
        assertArrayEquals(EXPECTED, actual);
    }
}