package br.com.hoptech.tests.udemy_tests.servicos;

import br.com.hoptech.tests.udemy_tests.daos.LocacaoDAO;
import br.com.hoptech.tests.udemy_tests.entidades.*;
import br.com.hoptech.tests.udemy_tests.utils.DataUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import static br.com.hoptech.tests.udemy_tests.utils.DataUtils.adicionarDias;

public class LocacaoService {

	private LocacaoDAO locacaoDAO;
	private SPCService spcService;
	private EmailService emailService;

	public LocacaoService(LocacaoDAO locacaoDAO, SPCService spcService, EmailService emailService) {
		this.locacaoDAO = locacaoDAO;
		this.spcService = spcService;
		this.emailService = emailService;
	}

	private static final double FILM_DISCOUNT_3 = 25;
	private static final double FILM_DISCOUNT_4 = 50;
	private static final double FILM_DISCOUNT_5 = 75;
	private static final double FILM_DISCOUNT_6 = 100;

	public Locacao alugarFilmes(Usuario usuario, List<Filme> filmes) {
		filmes.forEach(filme -> {
			if (filme.getEstoque().equals(0)) throw new FilmeSemEstoqueException("Filme sem Estoque");
		});
		boolean usuarioNegativado;
		try {
			usuarioNegativado = spcService.estaNegativado(usuario);
		} catch (RuntimeException e) {
			throw new SPCForaDoArException("Serviço de SPC está fora do ar");
		}
		if (usuarioNegativado) throw new UsuarioNegativadoNoSPCException("O usuário para efetuar a locação não pode estar negativado no SPC");

		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());

		double valorTotalComDescontos;
		valorTotalComDescontos = IntStream.range(0, filmes.size())
				.mapToDouble(i -> {
					switch (i) {
						case 2:
							return filmes.get(i).getPrecoLocacao()*(100-FILM_DISCOUNT_3)/100;
						case 3:
							return filmes.get(i).getPrecoLocacao()*(100-FILM_DISCOUNT_4)/100;
						case 4:
							return filmes.get(i).getPrecoLocacao()*(100-FILM_DISCOUNT_5)/100;
						case 5:
							return filmes.get(i).getPrecoLocacao()*(100-FILM_DISCOUNT_6)/100;
						default:
							return filmes.get(i).getPrecoLocacao();
					}
				})
				.reduce(0.0, Double::sum);
		locacao.setValorTotal(valorTotalComDescontos);

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);

		//Salvando a locacao...
		locacaoDAO.salvar(locacao);

		return locacao;
	}

	public void notificarAtrasos() {
		List<Locacao> locacacoes = locacaoDAO.obterLocacoesPendentes();
		locacacoes.forEach(locacao -> emailService.notificarAtraso(locacao.getUsuario()));
	}

	public void prorrogarLocacao(Locacao locacao) {
		Locacao locacaoProrrogada = new Locacao();
		locacaoProrrogada.setFilmes(locacao.getFilmes());
		locacaoProrrogada.setUsuario(locacao.getUsuario());
		locacaoProrrogada.setValorTotal(locacao.getValorTotal());
		locacaoProrrogada.setDataLocacao(locacao.getDataLocacao());
		locacaoProrrogada.setDataRetorno(adicionarDias(locacao.getDataRetorno(), 1));

		locacaoDAO.salvar(locacaoProrrogada);
	}


	/**
	 * Teste COM framework (JUnit), mas na propria classe
	 * Para o @Test poder ser usado aqui o escopo do JUnit no POM não deve estar como Test
	 * <scope>test</scope> Comentar essa linha
	 */
	/*
	@Test
	public void test() {
		//cenario
		LocacaoService locacaoService = new LocacaoService();
		Usuario usuario = new Usuario("Gustavo");
		Filme filme = new Filme("Matrix", 2, 5.0);

		//acao
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);

		//validacao
		Assert.assertTrue(locacao.getFilme().getNome().equals("Matrix"));
		Assert.assertTrue(locacao.getUsuario().getNome().equals("Gustavo"));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
	*/

}