package br.com.hoptech.tests.udemy_tests.daos;

import br.com.hoptech.tests.udemy_tests.entidades.Locacao;

import java.util.List;

public class LocacaoDAOFake implements LocacaoDAO {
    @Override
    public void salvar(Locacao locacao) {

    }

    @Override
    public List<Locacao> obterLocacoesPendentes() {
        return null;
    }
}
