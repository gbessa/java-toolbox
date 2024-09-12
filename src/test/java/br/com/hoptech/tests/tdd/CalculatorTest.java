package br.com.hoptech.tests.tdd;

import br.com.hoptech.tests.runners.ParallelRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@RunWith(ParallelRunner.class)
class CalculatorTest {

    Calculator calc;

    @Mock
    private Calculator calculatorMock;

    @Spy
    private Calculator calculatorSpy;

    @BeforeEach
    public void setUp() {
        calc = new Calculator();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void devoMostrarADiferencaEntreMockESpy() {
        System.out.println("#### MOCK ####");
        when(calculatorMock.sum(1,3)).thenReturn(5);
        System.out.println(calculatorMock.sum(1, 2));
        System.out.println(calculatorMock.sum(1, 3));

        System.out.println("#### SPY ####");
        when(calculatorSpy.sum(1,3)).thenReturn(5);
        System.out.println(calculatorSpy.sum(1, 2));
        System.out.println(calculatorSpy.sum(1, 3));

        // O SPY, quando não tem a instrução WHEN, faz a execução real do método,
        // já o MOCK devolve o valor default. No caso de int, é Zero
    }

    /**
     * https://www.baeldung.com/parameterized-tests-junit-5
     * Os paramentros podem ser inclusive, CSV ou mesmo outros métodos
     */
    private static Stream<Arguments> sumOperations() {
        return Stream.of(
                arguments(1, 3, 4),
                arguments(2, 4, 6),
                arguments(3, 4, 7)
        );
    }
    @ParameterizedTest
    @MethodSource("sumOperations")
    void shouldSum2ValuesParametrized(int a, int b, int result) {
        assertEquals(result, calc.sum(a, b));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, Integer.MAX_VALUE})
    void shouldSum2ValuesParametrized2(int a) {
        assertEquals(a, calc.sum(0, a));
    }

    @Test
    void shouldSum2Values() {
        // given
        Calculator calc = new Calculator();

        // when
        int actual = calc.sum(2, 3);
        final int EXPECTED = 5;

        // then
        assertEquals(EXPECTED, actual);
    }

    @Test
    void shouldSub2Values() {
        // given
        Calculator calc = new Calculator();

        // when
        int actual = calc.sub(2, 3);
        final int EXPECTED = -1;

        // then
        assertEquals(EXPECTED, actual);
    }

    @Test
    void shouldMult2Values() {
        // given
        Calculator calc = new Calculator();

        // when
        int actual = calc.mult(6, 3);
        final int EXPECTED = 18;

        // then
        assertEquals(EXPECTED, actual);
    }

    @Test
    void shouldDiv2Values() {
        // given
        Calculator calc = new Calculator();

        // when
        int actual = calc.div(6, 3);
        final int EXPECTED = 2;

        // then
        assertEquals(EXPECTED, actual);
    }

    @Test
    void shouldLaunchArithmeticException_when_divByZero() {
        // given
        Calculator calc = new Calculator();

        // when & then
        assertThrows(ArithmeticException.class, () -> calc.div(6, 0));
    }

    /**
     * Mock de métodos estáticos sem o PowerMock
     * Apenas a portir do Mokito 3.4
     */
    @Test
    public void deveMockarUmMetodoEstatico() {
        assertEquals("Calculate with Integers", Calculator.calcType());

        try (MockedStatic<Calculator> mocked = mockStatic(Calculator.class)) {
            mocked.when(Calculator::calcType).thenReturn("Retorno de mátodo estático mocado");
            assertEquals("Retorno de mátodo estático mocado", Calculator.calcType());
        }

        assertEquals("Calculate with Integers", Calculator.calcType());
    }

}
