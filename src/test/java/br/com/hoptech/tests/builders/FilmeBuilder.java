package br.com.hoptech.tests.builders;

import br.com.hoptech.tests.udemy_tests.entidades.Filme;
import br.com.hoptech.tests.udemy_tests.entidades.Usuario;
import com.github.javafaker.Faker;

public class FilmeBuilder {
    private FilmeBuilder(){};

    public static Filme buildFilmeComEstoque() {
        Faker faker = new Faker();
        return new Filme(new Faker().harryPotter().book(), 1, 10.0);
    }
}
