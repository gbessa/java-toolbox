package br.com.hoptech.algorithms.datastructures;

import java.util.stream.IntStream;

public class MyArrayList<T> {
    T[] arr;
    private static final int ARRAY_INITIAL_SIZE = 10;
    private int nextPosition = 0;

    MyArrayList() {
        arr = (T[]) new Object[ARRAY_INITIAL_SIZE];
    }

    public void add(T value) {
        if (nextPosition > arr.length-1) {
            T[] newArr = (T[]) new Object[arr.length + ARRAY_INITIAL_SIZE];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[nextPosition] = value;
        nextPosition++;
    }

    public T get(int i) {
        return arr[i];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int j = 0; j < nextPosition; j++) {
            if (j>0) sb.append(", ");
            sb.append(arr[j]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add(null);
        arrayList.add("C");
        System.out.println(arrayList.get(1));
        System.out.println(arrayList);

        MyArrayList<Integer> arrayList2 = new MyArrayList<>();
        IntStream.range(1, 22).forEach(arrayList2::add);
        System.out.println(arrayList2.get(12));
        System.out.println(arrayList2);
    }
}
