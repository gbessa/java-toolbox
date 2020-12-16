package br.com.hoptech.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void sum() {
        // given
        Calculator calc = new Calculator();

        // when
        int actual = calc.sum(2, 3);
        final int EXPECTED = 5;

        // then
        assertEquals(EXPECTED, actual);
    }

    @Test
    void sub() {
        // given
        Calculator calc = new Calculator();

        // when
        int actual = calc.sub(2, 3);
        final int EXPECTED = -1;

        // then
        assertEquals(EXPECTED, actual);
    }

    @Test
    void mult() {
        // given
        Calculator calc = new Calculator();

        // when
        int actual = calc.mult(6, 3);
        final int EXPECTED = 18;

        // then
        assertEquals(EXPECTED, actual);
    }

    @Test
    void div() {
        // given
        Calculator calc = new Calculator();

        // when
        int actual = calc.div(6, 3);
        final int EXPECTED = 2;

        // then
        assertEquals(EXPECTED, actual);
    }

    @Test
    void divByZero() {
        // given
        Calculator calc = new Calculator();

        // when
        int actual = calc.div(6, 0);
        final int EXPECTED = 2;

        // then
        assertEquals(EXPECTED, actual);
    }

}
