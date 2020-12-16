package br.com.hoptech.algorithms.sorting;

/**
O(n^2) no pior caso.
Percorre até n vezes a lista trocando os elementos adjacentes até que,
em um loop completo, nenhum elemento não seja mais trocado.
Algoritmos mais eficientes são: quicksort, timsort, e merge sort.
 */
public class BubbleSort implements Sorter {

    @Override
    public int[] sort(int[] arr) {
        return bubbleSort(arr);
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
