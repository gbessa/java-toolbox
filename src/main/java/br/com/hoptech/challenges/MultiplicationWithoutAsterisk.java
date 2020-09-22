package br.com.hoptech.challenges;

public class MultiplicationWithoutAsterisk {

    public static int multiply_firtsSolution(int a, int b) {

        boolean isNegativeResult = !(((a<0) && (b<0)) || ((a>=0) && (b>=0)));

        int result = 0;
        for (int counter=0; counter<Math.abs(a); counter++) {
            if (isNegativeResult){
                result-=Math.abs(b);
            } else {
                result+=Math.abs(b);
            };

        }
        return result;
    }

    // More elegant solution
    public static int multiply(int a, int b) {
        final Boolean positive = Math.abs(a) == a;
        int result = 0;

        for (int counter=0; counter<Math.abs(a); counter++) {
            result = positive ? result+b : result-b;
        }
        return result;
    }

}
