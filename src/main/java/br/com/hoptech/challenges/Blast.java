package br.com.hoptech.challenges;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Blast {
    private Random random;

    public static void main(String[] args) {
        new Blast().letterify("gust##avo");
    }

    Blast() {
        this.random = new Random();
    }

    public String bothify(String s) {
        return numerify(letterify(s));
    }

    public String letterify(String s) {
        if (s == null) return null;
        String[] strSplited = s.split("");
        final String strResult = Arrays.stream(strSplited).map(this::letterifyStrategy).collect(Collectors.joining());
        return strResult;
    }

    public String numerify(String s) {
        if (s == null) return null;
        String[] strSplited = s.split("");
        final String strResult = Arrays.stream(strSplited).map(this::numerifyStrategy).collect(Collectors.joining());
        return strResult;
    }

    public String letterifyStrategy(String s) {
        //System.out.println((char) ('a' + random.nextInt(25)));
        return s.equals("?") ? String.valueOf((char) ('a' + random.nextInt(25))) : s;
    }

    public String numerifyStrategy(String s) {
        return s.equals("#") ? String.valueOf(random.nextInt(9)) : s;
    }


}
