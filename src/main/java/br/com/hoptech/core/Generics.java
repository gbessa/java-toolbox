package br.com.hoptech.core;

public class Generics {

    public static void main(String[] args) {

	String[] arrS = {"Teste", "de", "Array"};

	Integer[] arrI = {3, 2, 1};
	
	printAGenericArray(arrS);
	
	printAGenericArray(arrI);
   
    }

    public static <T> void printAGenericArray(T[] arrayGeneric) {
	for(T item : arrayGeneric) {
	    System.out.println(item);
	}
    }
}
