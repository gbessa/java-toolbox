package br.com.hoptech.tests.udemy_tests.daos;

import br.com.hoptech.tests.udemy_tests.entidades.Locacao;

import java.util.List;

public interface LocacaoDAO {

    public void salvar(Locacao locacao);

    public List<Locacao> obterLocacoesPendentes();

}
