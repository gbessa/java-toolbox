package br.com.hoptech.algorithms.sorting;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Arrays;

/*
O(n^2) no pior caso.
Percorre até n vezes a lista trocando os elementos adjacentes até que,
em um loop completo, nenhum elemento não seja mais trocado.
Algoritmos mais eficientes são: quicksort, timsort, e merge sort.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 4, 9, 4, 1, 8, 7, 6, 8, 10, 2, 1, 0, -4};
        System.out.println(Arrays.toString(array));

        int[] arraySorted = bubbleSort(array);
        System.out.println(Arrays.toString(arraySorted));

    }

    private static int[] bubbleSort(int[] array) {
        int[] arraySorted = array;
        boolean swapped;
        int valueTemp;
        for (int i = 0; i < array.length; i++) {
            swapped = false;
            for (int j = 0; j < array.length-1; j++) {
                if (arraySorted[j]>arraySorted[j+1]) {
                    valueTemp = arraySorted[j];
                    arraySorted[j] = arraySorted[j+1];
                    arraySorted[j+1] = valueTemp;
                    swapped = true;
                }
            }
        }
        return arraySorted;
    }

}
