package br.com.hoptech.challenges;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class FindMaxNumberTest {

    FindMaxNumber findMaxNumber = new FindMaxNumber();

    @Test
    public void findMaxBetweenPositiveNumbers() {
        int actual = findMaxNumber.findMax(Arrays.asList(10, 1, 11, 23, 100, 8, 0));

        assertThat(actual).isEqualTo(100);
    }

    @Test
    public void findMaxBetweenPositiveAndNegativeNumbers() {
        int actual = findMaxNumber.findMax(Arrays.asList(10, 1, 11, 23, -100, 8, 0));

        assertThat(actual).isEqualTo(23);
    }

    @Test
    public void findMaxBetweenNegativeNumbers() {
        int actual = findMaxNumber.findMax(Arrays.asList(-10, -1, -11, -23, -100, -8));

        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void findMaxrBetweenNegativeNumbersAndANull() {
        assertThrows(NullPointerException.class, () -> {
            findMaxNumber.findMax(Arrays.asList(-10, null, -11, -23, -100, -8));
        });
    }

}
