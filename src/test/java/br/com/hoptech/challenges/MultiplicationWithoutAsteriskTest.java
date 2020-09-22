package br.com.hoptech.challenges;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationWithoutAsteriskTest {

    @Test
    public void multiplica2inteiros() {
        int a = 30;
        int b = 51;
        int expected = a * b;

        int actual = MultiplicationWithoutAsterisk.multiply(a,b);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplica1InteiroComZero() {
        int a = 0;
        int b = 20;
        int expected = a * b;

        int actual = MultiplicationWithoutAsterisk.multiply(a,b);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplica2InteirosSendo1Negativo() {
        int a = -2;
        int b = 20;
        int expected = a * b;

        int actual = MultiplicationWithoutAsterisk.multiply(a,b);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplica2InteirosSendo2Negativos() {
        int a = -2;
        int b = -20;
        int expected = a * b;

        int actual = MultiplicationWithoutAsterisk.multiply(a,b);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void multiplica2InteirosSendo1NegativoEOutro0() {
        int a = 0;
        int b = -20;
        int expected = a * b;

        int actual = MultiplicationWithoutAsterisk.multiply(a,b);

        assertThat(actual).isEqualTo(expected);
    }

}
