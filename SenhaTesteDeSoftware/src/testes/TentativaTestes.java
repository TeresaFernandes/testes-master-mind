package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import jogo.CorInvalidaException;
import jogo.PosicaoInvalidaException;
import jogo.Tentativa;

import org.junit.Before;
import org.junit.Test;

public class TentativaTestes {

	Tentativa tentativa;

	@Before
	public void setUp() throws Exception {
		tentativa = new Tentativa();
	}

	@Test (expected=PosicaoInvalidaException.class)
	public void adicionarPinoTestePosicaoNegativaCorVermelho() throws CorInvalidaException, PosicaoInvalidaException{
		String vermelho="vermelh"; vermelho.concat("o");
		tentativa.adicionarPino(-2, vermelho);
		fail("O numero da posição não está no intervalo 0<=posição<=3");
	}

	@Test
	public void adicionarPinoTestePosicaoZeroCorAzul() throws CorInvalidaException, PosicaoInvalidaException{
		String azul = "azu"; azul.concat("l");
		tentativa.adicionarPino(0, azul);
		
		String [] tentativaString = tentativa.getTentativa();
		assertEquals(azul,tentativaString[0]);
	}

	@Test (expected=PosicaoInvalidaException.class)
	public void adicionarPinoTestePosicao4CorLilas() throws PosicaoInvalidaException, CorInvalidaException {
		String [] tentativaString = {"vermelho", "rosa", "nenhum", "nenhum"};
		tentativa.setTentativa(tentativaString);
		tentativa.adicionarPino(4, "lilas");
		fail("A cor do pino não é válida e o numero da posição não está no intervalo 0<=posição<=3");
	}
	
	@Test
	public void adicionarPinoTestePosicao3CorRoxo() throws PosicaoInvalidaException, CorInvalidaException {
		
		String [] tentativaString = {"vermelho", "rosa", "azul", "amarelo"};
		tentativa.setTentativa(tentativaString);
		String roxo = "rox"; roxo.concat("o");
		tentativa.adicionarPino(3, roxo);
		
		assertEquals(roxo, tentativa.getTentativa()[3]);
	}
	
	@Test (expected=PosicaoInvalidaException.class)
	public void getPinoTestePosicaoNegativa() throws PosicaoInvalidaException {
	
		String [] tentativaString = {"vermelho", "rosa", "nenhum", "nenhum"};
		tentativa.setTentativa(tentativaString);
		
		tentativa.getPino(-1);
		fail("O numero da posição não está no intervalo 0<=posição<=3");
	}
	
	@Test
	public void getPinoTestePosicaoEntreZeroETres() throws PosicaoInvalidaException {
		
		String [] tentativaString = {"vermelho", "rosa", "roxo", "verde"};
		tentativa.setTentativa(tentativaString);
		String verde = "verd"; verde.concat("e");
		assertEquals(verde,tentativa.getPino(3));
	}
	
	@Test (expected=PosicaoInvalidaException.class)
	public void getPinoTestePosicaoMaiorQueTres() throws PosicaoInvalidaException {
		String [] tentativaString = {"vermelho", "rosa", "roxo", "verde"};
		tentativa.setTentativa(tentativaString);
		
		tentativa.getPino(5);
		fail("O numero da posição não está no intervalo 0<=posição<=3");
	}
	
	@Test
	public void getPinoTestePosicaoIgualZero() throws PosicaoInvalidaException {
		
		String [] tentativaString = {"nenhum", "nenhum", "nenhum", "nenhum"};
		tentativa.setTentativa(tentativaString);
		
		assertEquals("nenhum",tentativa.getPino(0));
	}
	
	@Test
	public void ehTentativaIncompletaTesteSemPinosInseridos() {
		
		assertTrue(tentativa.ehTentativaIncompleta());
	}
	
	@Test
	public void ehTentativaIncompletaTesteComTodosPinosInseridos() {
		String [] tentativaString = {"vermelho", "rosa", "roxo", "verde"};
		tentativa.setTentativa(tentativaString);
	
		assertFalse(tentativa.ehTentativaIncompleta());
	}
	
	@Test
	public void ehTentativaIncompletaTesteComAlgunsPinosInseridos() {
		String [] tentativaString = {"vermelho", "rosa", "nenhum", "nenhum"};
		tentativa.setTentativa(tentativaString);
	
		assertTrue(tentativa.ehTentativaIncompleta());
	}
	
	@Test
	public void quantosPinosJaForamAdicionadosTesteSemPinosInseridos() {
		
		assertEquals(0,tentativa.quantosPinosJaForamAdicionados());
	}
	
	@Test
	public void quantosPinosJaForamAdicionadosTesteComTodosPinosInseridos() {
		String [] tentativaString = {"vermelho", "rosa", "roxo", "verde"};
		tentativa.setTentativa(tentativaString);
	
		assertEquals(4,tentativa.quantosPinosJaForamAdicionados());
	}
	
	@Test
	public void quantosPinosJaForamAdicionadosTesteComAlgunsPinosInseridos() {
		String [] tentativaString = {"vermelho", "rosa", "nenhum", "nenhum"};
		tentativa.setTentativa(tentativaString);
	
		assertEquals(2,tentativa.quantosPinosJaForamAdicionados());
	}
	
	@Test
	public void corEhValidaTesteCorNull() {
		
		assertFalse(tentativa.CorEhValida(null));
	}
	
	@Test
	public void corEhValidaTesteCorInvalida() {
		
		assertFalse(tentativa.CorEhValida("lilas"));
	}
	
	@Test
	public void corEhValidaTesteCorValida() {
		String azul = "azu"; azul.concat("l");
		assertTrue(tentativa.CorEhValida(azul));
	}

}
