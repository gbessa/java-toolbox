package br.com.hoptech.challenges;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Blast {
    private Random random;

    public static void main(String[] args) {
        System.out.println(new Blast().letterify("gustavo?"));

        System.out.println(new Blast().bothify("gustavo?#"));
    }

    Blast() {
        this.random = new Random();
    }

    public String bothify(String s) {
        return numerify(letterify(s));
    }

    public String letterify(String s) {
        if (s == null) return null;
        return split(s)
                .map(this::letterifyStrategy)
                .collect(Collectors.joining());
    }

    public String numerify(String s) {
        if (s == null) return null;
        return split(s)
                .map(this::numerifyStrategy)
                .collect(Collectors.joining());
    }

    public String letterifyStrategy(String s) {
        return s.equals("?") ? String.valueOf((char) ('a' + random.nextInt(25))) : s;
    }

    public String numerifyStrategy(String s) {
        return s.equals("#") ? String.valueOf(random.nextInt(9)) : s;
    }

    public Stream<String> split(String s) {
        return Pattern.compile("").splitAsStream(s);
    }


}
