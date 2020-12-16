package br.com.hoptech.challenges;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Test(timeOut = 1000)
public class BlastTest {

    // bothify
    public void shouldEmbedRandomElementsInText() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.bothify("Test?#");

        //then
        assertThat(result).matches("Test[a-z][0-9]");
    }

    // defensive verification
    public void letterifyWithEmptyString() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.letterify("");

        //then
        assertThat(result).matches("");
    }

    public void letterifyWithNull() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.letterify(null);

        //then
        boolean nullOrEmpty = result == null || "".equals(result);
        assertTrue(nullOrEmpty);
    }

    public void numerifyWithEmptyString() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.numerify("");

        //then
        assertThat(result).matches("");
    }

    public void numerifyWithNull() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.numerify(null);

        //then
        boolean nullOrEmpty = result == null || "".equals(result);
        assertTrue(nullOrEmpty);
    }

    // letterify
    public void shouldCreateRandomText() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.letterify("???");

        //then
        assertThat(result).matches("[a-z][a-z][a-z]");
    }

    public void shouldEmbedRandomLetterInText() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.letterify("Test?");

        //then
        assertThat(result).matches("Test[a-z]");
    }

    public void shouldGenerateOnlyLettersInText() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.letterify("Test??##");

        //then
        assertThat(result).matches("Test[a-z][a-z]##");
    }

    // mixedvalues
    public void letterifyShouldGenerateOnlyLettersInText() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.letterify("Test??##");

        //then
        assertThat(result).matches("Test[a-z][a-z]##");
    }

    public void numerifyShouldGenerateOnlyNumbersInText() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.numerify("Test??##");

        //then
        assertThat(result).matches("Test\\?\\?[0-9][0-9]");
    }

    // numerify
    public void shouldCreateRandomNumber() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.numerify("###");

        //then
        assertThat(result).matches("[0-9][0-9][0-9]");
    }

    public void shouldEmbedRandomNumberInText() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.numerify("Test#");

        //then
        assertThat(result).matches("Test[0-9]");
    }

    public void shouldGenerateOnlyNumbersInText() {
        //given
        Blast blast = new Blast();

        //when
        String result = blast.numerify("Test??##");

        //then
        assertThat(result).matches("Test\\?\\?[0-9][0-9]");
    }

    // random
    private static final int TRIES = 3;

    public void letterifyRandomness() {
        //given
        Blast blast = new Blast();

        //when
        Set<String> results = new HashSet<String>();
        for (int i = 0; i < TRIES; i++) {
            results.add(blast.letterify("???"));
        }

        //then
        assertThat(results).hasSize(TRIES);
    }

    public void numerifyRandomness() {
        //given
        Blast blast = new Blast();

        //when
        Set<String> results = new HashSet<String>();
        for (int i = 0; i < TRIES; i++) {
            results.add(blast.numerify("###"));
        }

        //then
        assertThat(results).hasSize(TRIES);
    }

    public void botifyRandomness() {
        //given
        Blast blast = new Blast();

        //when
        Set<String> results = new HashSet<String>();
        for (int i = 0; i < TRIES; i++) {
            results.add(blast.bothify("##??"));
        }

        //then
        assertThat(results).hasSize(TRIES);
    }


}