package br.com.hoptech.tests.builders;

import br.com.hoptech.tests.udemy_tests.entidades.Usuario;
import com.github.javafaker.Faker;

public class UsuarioBuilder {

    private UsuarioBuilder(){};

    public static Usuario buildUsuario() {
        Faker faker = new Faker();
        return new Usuario(faker.name().fullName());
    }

}
