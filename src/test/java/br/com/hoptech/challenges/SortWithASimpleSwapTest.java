package br.com.hoptech.challenges;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortWithASimpleSwapTest {

    // given
    SortWithASimpleSwap sortWithASimpleSwap = new SortWithASimpleSwap();
    int[] arraySorteable = {1, 4, 2, 9, 10};
    int[] arrayNotSorteable = {1, 4, 9, 3, 10};

    @Test
    public void isSorteable() {
        // then
        assertTrue(sortWithASimpleSwap.isSorteable(arraySorteable));
    }

    @Test
    public void isNotSorteable() {
        // then
        assertFalse(sortWithASimpleSwap.isSorteable(arrayNotSorteable));
    }

}