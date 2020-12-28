package br.com.hoptech.java8.lambdas;

import org.junit.Test;

import java.util.InvalidPropertiesFormatException;

import static org.junit.jupiter.api.Assertions.*;

public class MyCodeTest {

    @Test
    public void shouldSum() {
        // given
        String[] input = new String[]{"1","3","2", "4"};

        // when
        int actual = MyCode.sumOfEvenNumbers(input);

        // then
        assertEquals(6, actual);
    }

    @Test
    public void shouldSum2() {
        // given
        String[] input = new String[]{"1","3","2a", "4"};

        // when
        assertThrows(IllegalArgumentException.class, () -> MyCode.sumOfEvenNumbers(input));

    }

    @Test
    public void shouldSum3() {
        // given
        String[] input = new String[]{"1","3","5", "7"};

        // when
        int actual = MyCode.sumOfEvenNumbers(input);

        // then
        assertEquals(0, actual);
    }

   @Test
    public void shouldSum4() {
        // given
        String[] input = new String[]{};

        // when
        int actual = MyCode.sumOfEvenNumbers(input);

        // then
        assertEquals(0, actual);
    }

//    @Test
//    public void shouldSum5() {
//        // given
//        String[] input = new String[]{String.valueOf(Integer.MAX_VALUE-1), "100"};
//
//        System.out.println(MyCode.sumOfEvenNumbers(input));
//
//        //
//        assertThrows(IllegalArgumentException.class, () -> MyCode.sumOfEvenNumbers(input));
//    }

    @Test
    public void shouldSum5() {
        // given
        String[] input = new String[]{"2.2", "2"};

        assertThrows(IllegalArgumentException.class, () -> MyCode.sumOfEvenNumbers(input));
    }

    @Test
    public void shouldSum6() {
        // given
        //String[] input = new String[]{"2.2", "2"};

        assertThrows(IllegalArgumentException.class, () -> MyCode.sumOfEvenNumbers(null));
    }


}