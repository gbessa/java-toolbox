package br.com.hoptech.java8.lambdas;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * Supplier - Não recebe nada mas retorna um Generics
 *  Ex: usado no generate
 *
 * Consumer - Oposto do Supplier. Recebe um valor, mas não retorna nada
 *  Ex: usado no forEach
 *
 * BiConsumer - Semelhante ao consumer, mas recebendo 2 valores
 *
 * Predicate - Recebe um valor e retorna um Boolean
 *  Ex: Usado no Filter
 *
 * BiPredicate - Recebe 2 parâmetros e retorna um Boolean
 *
 * Function - Recebe um valor e retorna um valor
 *  Ex: Usado no Map
 *
 * BiFunction - Function com 2 entradas
 *
 * UnaryOperator - Semelhante ao Function, mas o tipo de entrada e de saída dever ser iguais
 *
 * BinaryOperator - UnaryOperator com 2 entradas
 *  ex: usado no reduce
 */
public class FunctionalIntefaces  {

    public static void main(String[] args) {

        /**
         * Supplier
         */
        Stream.generate(() -> new Random().nextInt(1000))
                .limit(10)
                .forEach(System.out::println);

        Stream.generate(new Randomizer())
                .limit(10)
                .forEach(System.out::println);

    }

}

class Randomizer implements Supplier<Integer> {

    @Override
    public Integer get() {
        return new Random().nextInt(10);
    }
}
