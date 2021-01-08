package br.com.hoptech.tests.udemy_tests.servicos;

import br.com.hoptech.tests.udemy_tests.entidades.Usuario;

public interface EmailService {

    public void notificarAtraso(Usuario usuario);
}
