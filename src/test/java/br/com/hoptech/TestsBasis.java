package br.com.hoptech;

import lombok.extern.log4j.Log4j2;
import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

/**
 * - @Before e @After
 *      são executados antes e depois de CADA teste
 *
 * - @BeforeClass e @AfterClass
 *      são executados antes e depois da execução dos testes
 *      precisam ser estáticos
 *
 * - @BeforeEach and @BeforeAll
 *      são novos nomes usados no JUNIT 5 para as mesmas funcionalidades das anotações anteriores
 *
 */
@Log4j2
public class TestsBasis {

    private List<String> listExample;

    /**
     * JUNIT 5
     @BeforeAll
     public static void setupJunit5() {
     log.info("setupJunit5");
     }

     @BeforeEach
     public static void beforeJunit5() {
     log.info("beforeJunit5");
     }
     */

    @BeforeClass
    public static void setup() {
        log.info("setup - expensive operations, like creating DB connection");
    }

    @AfterClass
    public static void tearDown() {
        log.info("tearDown - closing DB connection");
    }

    @Before
    public void before() {
        log.info("before");
        listExample = new ArrayList<>();
    }

    @After
    public void after() {
        log.info("after");
        listExample.clear();
    }

    @Test
    public void test1() {
        // given

        // and

        // when

        // then

        log.info("test1");
    }

    @Test
    public void test2() {
        log.info("test2");
    }

}
