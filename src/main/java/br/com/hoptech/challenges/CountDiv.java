package br.com.hoptech.challenges;

public class CountDiv {

    public static void main(String[] args) {
        System.out.println(new CountDiv().run(11, 345, 17));
    }

    int run(int A, int B, int K) {
        int i = A;
        while (i < B && i%K!=0) i++;
        int jumps = 0;
        if (i%K==0) {
            jumps = (B-i)/K + 1;
        }
        return jumps;
    }
}
