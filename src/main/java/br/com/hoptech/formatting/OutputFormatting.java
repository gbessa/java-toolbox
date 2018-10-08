package br.com.hoptech.formatting;

import java.util.Scanner;

public class OutputFormatting {

    public static void main(String[] args) {
	
        tableFormat();
        tabuada(10);

    }

    private static void tabuada(int multiplier) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d\n", multiplier, i, multiplier*i);
        }
    }

    /*
     * Prints the 2 data formated into a text table
     * DATA1         VALUE1
     * OTHER DATA    VALUE2
     */
    private static void tableFormat() {
	Scanner sc = new Scanner(System.in);
        String f = "%1$-15s%2$03d\n";
        for(int i=0;i<3;i++){
            String s1 = sc.next();
            int x = sc.nextInt();
            System.out.printf(f, s1, x);
        }
    }

}


