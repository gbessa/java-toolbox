package br.com.hoptech.tests.udemy_tests.servicos;

import br.com.hoptech.tests.builders.FilmeBuilder;
import br.com.hoptech.tests.builders.LocacaoBuilder;
import br.com.hoptech.tests.builders.UsuarioBuilder;
import br.com.hoptech.tests.udemy_tests.daos.LocacaoDAO;
import br.com.hoptech.tests.udemy_tests.daos.LocacaoDAOFake;
import br.com.hoptech.tests.udemy_tests.entidades.*;
import br.com.hoptech.tests.udemy_tests.utils.DataUtils;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Para usar ativar o Mokito, alem das anotações @Mock,
 * tem que usar a => @ExtendWith(MockitoExtension.class)
 * ou
 * rodar no @Before o => MockitoAnnotations.initMocks(this);
 */
@ExtendWith(MockitoExtension.class)
class LocacaoServiceTest {
    List<Filme> filmes;
    Usuario usuario;

    /**
     * Moca as dependências e as injeta na classe de teste (LocacaoService)
     */
    @Mock private LocacaoDAO locacaoDAO;
    @Mock private SPCService spcService;
    @Mock private EmailService emailService;

    @InjectMocks
    private LocacaoService locacaoService;

    @BeforeEach
    public void setup() {
        filmes = new ArrayList<>();
        usuario = UsuarioBuilder.buildUsuario();
    }

    @AfterEach
    public void tearDown() {
        filmes.clear();
        usuario = null;
    }

    @Test
    public void deveAlugarFilmesComSucesso() {
        //cenario
        filmes.add(new Filme("Matrix", 2, 5.0));
        filmes.add(new Filme("Fast and Furious", 2, 4.0));
        filmes.add(new Filme("Lion King", 2, 3.0));
        when(spcService.estaNegativado(usuario)).thenReturn(false);

        //acao
        Locacao locacao = locacaoService.alugarFilmes(usuario, filmes);

        //validacao
        assertEquals("Matrix", locacao.getFilmes().get(0).getNome());
        assertEquals(usuario.getNome(), locacao.getUsuario().getNome());
        assertEquals(11.25, locacao.getValorTotal()); // No JUnit 4, ao comparar doubles, tinha que passar um Delta de margem de erro
        assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
        /**
         *  Outras Assertions
         *      assertThrows()
         *      assertNull()
         *      assertNotEquals()
         *      assertSame() => Verifica se 2 objetos são a mesma instancia
         */

        /**
         *  Fluent Interface (Martin Fowler) - https://martinfowler.com/bliki/FluentInterface.html
         *  Usamos os Matchers do CoreMatchers do Hamcrest
         */
        assertThat(locacao.getFilmes().get(0).getNome(), is(equalTo("Matrix")));
    }

    @Test
    public void deveLancarExcecaoSeNaoHouverFilmeEmEstoque() {
        // given
        filmes.add(new Filme("Matrix", 0, 5.0));

        // when, then
        assertThrows(FilmeSemEstoqueException.class, () -> locacaoService.alugarFilmes(usuario, filmes));

        // Para testar a Exception e mais a Mensagem tb

        Throwable exceptionThatWasThrown =
                assertThrows(FilmeSemEstoqueException.class, () -> locacaoService.alugarFilmes(usuario, filmes));
        assertThat(exceptionThatWasThrown.getMessage(), equalTo("Filme sem Estoque"));

    }

    @Test
    public void deveLancarExcecaoSeNaoHouverFilmeEmEstoque_Juni4() {
        // given
        filmes.add(new Filme("Matrix", 0, 5.0));

        // when, then
        try {
            locacaoService.alugarFilmes(usuario, filmes);
            Assert.fail("Deve lançar Exception");
        } catch (Exception e) {
            assertThat(e.getClass(), is(FilmeSemEstoqueException.class));
            assertThat(e.getMessage(), is("Filme sem Estoque"));
        }
    }

    @Test
    @DisplayName("deveAplicarDesconto -> 25% No Terceiro Filme")
    public void deveAplicarDescontoDe25NoTerceiroFilme() {
        // given
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));

        Locacao locacao = locacaoService.alugarFilmes(usuario, filmes);
        Locacao locacaoDesconto = locacaoService.alugarFilmes(usuario, filmes);
        assertEquals(27.5, locacaoDesconto.getValorTotal());
    }

    @Test
    @DisplayName("deveAplicarDesconto -> 50% No Quarto Filme")
    public void deveAplicarDescontoDe50NoQuartoFilme() {
        // given
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));

        Locacao locacao = locacaoService.alugarFilmes(usuario, filmes);
        Locacao locacaoDesconto = locacaoService.alugarFilmes(usuario, filmes);
        assertEquals(32.5, locacaoDesconto.getValorTotal());
    }

    @Test
    @DisplayName("deveAplicarDesconto -> 75% No Quinto Filme")
    public void deveAplicarDescontoDe75NoQuintoFilme() {
        // given
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));

        Locacao locacao = locacaoService.alugarFilmes(usuario, filmes);
        Locacao locacaoDesconto = locacaoService.alugarFilmes(usuario, filmes);
        assertEquals(35.0, locacaoDesconto.getValorTotal());
    }

    @Test
    @DisplayName("deveAplicarDesconto -> 100% No Sexto Filme")
    public void deveAplicarDescontoDe100NoSextoFilme() {
        // given
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));

        Locacao locacao = locacaoService.alugarFilmes(usuario, filmes);
        Locacao locacaoDesconto = locacaoService.alugarFilmes(usuario, filmes);
        assertEquals(35.0, locacaoDesconto.getValorTotal());
    }

    @Test
    public void naoDeveAplicarDescontoNoSetimoFilme() {
        // given
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));
        filmes.add(new Filme("Matrix", 1, 10.0));

        Locacao locacao = locacaoService.alugarFilmes(usuario, filmes);
        Locacao locacaoDesconto = locacaoService.alugarFilmes(usuario, filmes);
        assertEquals(45.0, locacaoDesconto.getValorTotal());
    }

    @Test
    public void naoDeveAlugarParaUsuarioNegativadoNoSPC() {
        filmes.add(new Filme("Matrix", 1, 10.0));

        when(spcService.estaNegativado(usuario)).thenReturn(true);

        assertThrows(UsuarioNegativadoNoSPCException.class, () -> locacaoService.alugarFilmes(usuario, filmes));

        Mockito.verify(spcService).estaNegativado(usuario);
    }

    @Test
    public void deveEnviarEmailParaLocacoesAtrasadas() {
        // given
        Locacao locacao = new Locacao();
        locacao.setUsuario(usuario);
        List<Locacao> locacoesPendentes = Arrays.asList(locacao);
        when(locacaoDAO.obterLocacoesPendentes()).thenReturn(locacoesPendentes);

        // when
        locacaoService.notificarAtrasos();

        // then
        Mockito.verify(emailService).notificarAtraso(usuario);
    }

    @Test
    public void deveTratarErroNoSPC() {
        //cenario
        filmes.add(new Filme("Matrix", 2, 5.0));
        when(spcService.estaNegativado(usuario)).thenThrow(new RuntimeException("SPC fora do ar"));

        assertThrows(SPCForaDoArException.class, () -> locacaoService.alugarFilmes(usuario, filmes));
    }

    @Test
    public void deveProrrogarALocacaoEmUmDia() {
        //cenario
        filmes.add(new Filme("Matrix", 2, 5.0));

        Locacao locacao = LocacaoBuilder.builLocacao(3);
        locacaoService.prorrogarLocacao(locacao);

        ArgumentCaptor<Locacao> argumentCaptor = ArgumentCaptor.forClass(Locacao.class);
        Mockito.verify(locacaoDAO).salvar(argumentCaptor.capture());
        Locacao locacaoSalva = argumentCaptor.getValue();
        assertTrue(DataUtils.isMesmaData(locacaoSalva.getDataRetorno(), DataUtils.obterDataComDiferencaDias(2)));
    }

    @Test
    public void naoDeveDevolverFilmeNoDomingo() {
        Locacao locacao = locacaoService.alugarFilmes(UsuarioBuilder.buildUsuario(), Arrays.asList(FilmeBuilder.buildFilmeComEstoque()));
        //acao
        assertTrue(DataUtils.verificarDiaSemana(locacao.getDataRetorno(), Calendar.MONDAY));
    }

    @Test
    @Disabled
    public void deveDesabilitarOTeste() {
        Locacao locacao = locacaoService.alugarFilmes(usuario, Arrays.asList(new Filme("Matrix", 1, 10.0)));
        assertTrue(DataUtils.verificarDiaSemana(locacao.getDataRetorno(), Calendar.MONDAY));
    }

}