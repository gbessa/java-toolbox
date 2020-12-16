package br.com.hoptech.challenges;

public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(new FrogJmp().run(10, 85, 30));
    }

    int run(int X, int Y, int D) {
        return (int) Math.ceil(Double.valueOf(Y-X)/D);
    }
}
