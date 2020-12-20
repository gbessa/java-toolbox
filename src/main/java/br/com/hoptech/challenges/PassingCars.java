package br.com.hoptech.challenges;

import java.util.ArrayList;
import java.util.Collections;

public class PassingCars {
    public static void main(String[] args) {
        int[] arrayIn = {0, 1, 0, 1, 1};
        System.out.println(new PassingCars().run(arrayIn));
    }

    int run(int[] A) {

        int goingWest = 0;
        Long passings = 0L;
        for (int i = A.length-1; i>=0; i--) {
            if (A[i] == 1) {
                goingWest++;
            } else {
                passings+= goingWest;
            }
        }
        return passings>1000000000L ? -1 : passings.intValue();
    }
}
