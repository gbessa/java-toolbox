package br.com.hoptech.algorithms.sorting;

import java.util.Arrays;

/*
É um algorítmo recursivo baseado em divide and conquer, a partir do encontro de um pivot.
Java Arrays.sort implementa o Quicksort para ordenar primitivos
Pior caso: O(n^2)
Na média: O(n.log(n))
Funcionamento: Encontrar o Pivot, executar recursivamente nas 2 sublistas e fazer o merge.
Não é Stable, ou seja, pode trocar de posição valores iguais.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 4, 9, 4, 4, 4, 1, 8, 7, 6, 8, 10, 2, 1, 0, -4};
        System.out.println(Arrays.toString(array));

        int[] arraySorted = quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(arraySorted));

    }

    public static int[] quickSort(int arr[], int begin, int end) {
        int[] arraySorted = arr;
        if (begin < end) {
            int pivotLocation = partition(arraySorted, begin, end);

            quickSort(arraySorted, begin, pivotLocation-1);
            quickSort(arraySorted, pivotLocation+1, end);
        }
        return arraySorted;
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int leftWall = begin;

        for (int scanPos = begin; scanPos < end; scanPos++) {
            if (arr[scanPos] < pivot) {
                swap(arr, scanPos, leftWall);
                leftWall++;
            }
        }
        swap(arr, end, leftWall);

        return leftWall;
    }

    private static void swap(int arr[], int pos1, int pos2) {
        int swapTemp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = swapTemp;
    }

}
