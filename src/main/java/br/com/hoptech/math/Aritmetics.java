package br.com.hoptech.math;

public class Aritmetics {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }
    
    boolean isPrime(int n) {
        boolean prime = true;
        for (int i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) {
                prime = false;
                break;
            }
        if (( n%2 !=0 && prime && n > 2) || n == 2) {
            return true;
        } else {
            return false;
        }
    }

}
