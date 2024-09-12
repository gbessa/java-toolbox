package br.com.hoptech.certification;

public class Question04 {
    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder(" Mundo");

        String str2 = "Olá";

        System.out.println(str2.concat(str1.toString()));

        System.out.println(str2.concat(str1+""));

    }
}
