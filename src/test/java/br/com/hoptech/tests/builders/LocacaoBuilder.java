package br.com.hoptech.tests.builders;

import br.com.hoptech.tests.udemy_tests.entidades.Filme;
import br.com.hoptech.tests.udemy_tests.entidades.Locacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static br.com.hoptech.tests.udemy_tests.utils.DataUtils.adicionarDias;

public class LocacaoBuilder {
    private LocacaoBuilder(){};

    public static Locacao builLocacao(int qtdFilmes) {
        Locacao locacao = new Locacao();

        locacao.setUsuario(UsuarioBuilder.buildUsuario());
        locacao.setDataLocacao(new Date());
        locacao.setDataRetorno(adicionarDias(new Date(), 1));
        locacao.setValorTotal(10.0);

        List<Filme> filmes = new ArrayList<>();

        for (int i=1; i<=qtdFilmes; i++) filmes.add(FilmeBuilder.buildFilmeComEstoque());

        locacao.setFilmes(filmes);

        return locacao;
    }
}
