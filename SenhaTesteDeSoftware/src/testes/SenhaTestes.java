package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import jogo.CorInvalidaException;
import jogo.PosicaoInvalidaException;
import jogo.Senha;

import org.junit.Before;
import org.junit.Test;

public class SenhaTestes {

	Senha senha;
	String azul;
	String vermelho;
	String rosa;
	String amarelo;
	String lilas;
	
	@Before
	public void setUp() throws Exception {
		senha = new Senha();
	}

/*	@Test (expected=PosicaoInvalidaException.class)
	public void adicionarPinoTestePosicaoNegativaCorVermelho() throws CorInvalidaException, PosicaoInvalidaException {
		
		senha.setPinosInseridos(-1);
		senha.adicionarPino("vermelho");
		fail("O numero de pinos inseridos não está no intervalo 0<=posição<=3");
		
	}*/
	
	@Test
	public void adicionarPinoTestePosicaoZeroCorAzul() throws CorInvalidaException{
		senha.setPinosInseridos(0);
		String azul = "az";
		azul.concat("ul");
		senha.adicionarPino(azul);
		
		String [] senhaString = senha.getSenha();
		assertEquals(azul,senhaString[0]);
	}

	@Test (expected=CorInvalidaException.class)
	public void adicionarPinoTestePosicao4CorLilas() throws CorInvalidaException {
		String [] senhaString = {"vermelho", "rosa", "nenhum", "nenhum"};
		senha.setSenha(senhaString);
		senha.setPinosInseridos(4);
		senha.adicionarPino("lilas");
		fail("A cor do pino não é válida e o numero da posição não está no intervalo 0<=posição<=3");
	}
	
	@Test
	public void adicionarPinoTestePosicao3CorRoxo() throws PosicaoInvalidaException, CorInvalidaException {
		
		String [] senhaString = {"vermelho", "rosa", "azul", "amarelo"};
		senha.setSenha(senhaString);
		senha.setPinosInseridos(3);
		String roxo = "rox"; roxo.concat("o");
		senha.adicionarPino(roxo);
		
		assertEquals(roxo, senha.getSenha()[3]);
	}
	
	@Test
	public void corEhValidaTesteCorNull() {
		
		assertFalse(senha.CorEhValida(null));
	}
	
	@Test
	public void corEhValidaTesteCorInvalida() {
		String lilas = "lila"; lilas.concat("s");
		assertFalse(senha.CorEhValida(lilas));
	}
	
	@Test
	public void corEhValidaTesteCorValida() {
		String azul = "azu"; azul.concat("l");
		assertTrue(senha.CorEhValida(azul));
	}
	
	@Test (expected=PosicaoInvalidaException.class)
	public void getPinoTestePosicaoNegativa() throws PosicaoInvalidaException {
		String [] senhaString = {"vermelho", "rosa", "nenhum", "nenhum"};
		senha.setSenha(senhaString);
		
		senha.getPino(-1);
		fail("O numero da posição não está no intervalo 0<=posição<=3");
	}
	
	@Test
	public void getPinoTestePosicaoEntreZeroETres() throws PosicaoInvalidaException {
		
		String [] senhaString = {"vermelho", "rosa", "roxo", "verde"};
		senha.setSenha(senhaString);
		
		assertEquals("verde",senha.getPino(3));
	}
	
	@Test (expected=PosicaoInvalidaException.class)
	public void getPinoTestePosicaoMaiorQueTres() throws PosicaoInvalidaException {
			String [] senhaString = {"vermelho", "rosa", "roxo", "verde"};
			senha.setSenha(senhaString);
			
			senha.getPino(5);
			fail("O numero da posição não está no intervalo 0<=posição<=3");
	}
	
	@Test
	public void getPinoTestePosicaoIgualZero() throws PosicaoInvalidaException {
		
		String [] senhaString = {"nenhum", "nenhum", "nenhum", "nenhum"};
		senha.setSenha(senhaString);
		
		assertEquals("nenhum",senha.getPino(0));
	}
	
	@Test
	public void ehSenhaValidaTesteArraySemPinos()  {
		assertFalse(senha.ehSenhaValida());
	}
	
	@Test
	public void ehSenhaValidaTesteArrayComAlgunsPinos()  {
		String [] senhaString = {"vermelho", "rosa", "roxo", "nenhum"};
		senha.setSenha(senhaString);
		
		assertFalse(senha.ehSenhaValida());
	}
	
	@Test
	public void ehSenhaValidaTesteArrayComAlgunsPinosRepetidos()  {
		String [] senhaString = {"vermelho", "rosa", "roxo", "roxo"};
		senha.setSenha(senhaString);
		
		assertFalse(senha.ehSenhaValida());
	}
	
	@Test
	public void ehSenhaValidaTesteArrayComTodosOsPinosAlgunsInvalidos()  {
		String [] senhaString = {"vermelho", "rosa", "roxo", "lilas"};
		senha.setSenha(senhaString);
		
		assertFalse(senha.ehSenhaValida());
	}
	
	
	@Test
	public void ehSenhaValidaTesteArrayComTodosPinos() throws PosicaoInvalidaException {
		String [] senhaString = {"vermelho", "rosa", "roxo", "azul"};
		senha.setSenha(senhaString);
		
		assertTrue(senha.ehSenhaValida());
	}
	
	
	
}