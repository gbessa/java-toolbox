package br.com.hoptech.hrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaSubarray {

    public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	
	int n = scan.nextInt();
	
	List<Integer> arr = new ArrayList<Integer>(); 
	
	for (int i=0; i<n; i++) {
	    int v = scan.nextInt();
	    arr.add(v);
	}
	
	Integer sub = 0;
	Integer counter = 0;
	for (int j=0; j<n; j++) {
	    
	    for (int k=j; k<n; k++) {
		sub = arr.subList(j, k+1).stream().mapToInt(i -> i.intValue()).sum();		
		System.out.println("[" + j + "," + k + "] -> " + arr.subList(j, k+1) + " -> " + sub);
		if (sub < 0) counter++;
	    }
	}
	
	System.out.println(counter);
	
	scan.close();

    }

}
