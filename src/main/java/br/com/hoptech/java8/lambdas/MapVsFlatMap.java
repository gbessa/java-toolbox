package br.com.hoptech.java8.lambdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = list.stream().map(Math::negateExact).collect(Collectors.toList());
        System.out.println(list2);

//        List<Integer> list3 = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
//        System.out.println(list3);
    }


}
