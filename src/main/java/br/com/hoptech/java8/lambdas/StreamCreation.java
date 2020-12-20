package br.com.hoptech.java8.lambdas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * - Collections
 * - classe Arrays
 * - Stream.of
 * - IntStream.range e IntStream.rangeClosed
 * - Stream.iterate
 * - Random
 * - Pattern
 * - BufferedReader - lines
 * - Files
 */
public class StreamCreation {

    public static void main(String[] args) {

        /**
         * Via Collections (List e Collections implementam o .stream
         */
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.stream().forEach(System.out::println);

        /**
         * Via classe Arrays
         */
        Integer[] intArray = new Integer[] {1, 2, 3};
        Arrays.stream(intArray).forEach(System.out::println);

        /**
         * Via Stream.of
         */
        Stream.of(1, 2, 3).forEach(System.out::println);

        /**
         * Via IntStream.range e IntStream.rangeClosed
         */
        IntStream.range(1, 4).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        /**
         * Via Stream.iterate (seed é o valor inicial, e se não colocar limit ele não para de iterar)
         */
        Stream.iterate(1, n -> n + 1)
                .limit(3)
                .forEach(System.out::println);

        /**
         * Via Random
         */
        new Random().ints(3)
                .forEach(System.out::println);

        /**
         * Via Pattern
         */
        String s = "01;02;03";
        Pattern pattern = Pattern.compile(";");
        pattern.splitAsStream(s).forEach(System.out::println);

        /**
         * Via BufferedReader - lines
         */
        File file = new File("src/main/resources/lines.txt");
        try {
            FileReader in = new FileReader(file);
            BufferedReader br = new BufferedReader(in);
            br.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * Via Files
         */
        Path p = Paths.get("src/main/resources/");
        try {
            Files.list(p).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
