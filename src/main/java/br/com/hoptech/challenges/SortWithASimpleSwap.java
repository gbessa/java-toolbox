package br.com.hoptech.challenges;

import java.util.Arrays;

public class SortWithASimpleSwap {

    public boolean isSorteable(int[] array) {
        boolean oneSwapWasMade = false;
        for (int i = 0; i < array.length; i++) {
            for (int a = 0; a < array.length - 1; a++) {
                if (array[a] > array[a + 1]) {
                    if (oneSwapWasMade) return false;
                    int temp = array[a];
                    array[a] = array[a + 1];
                    array[a + 1] = temp;
                    oneSwapWasMade = true;
                }
            }
        }
        return true;
    }

}
