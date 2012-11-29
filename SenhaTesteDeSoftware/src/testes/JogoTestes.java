package testes;

import static org.junit.Assert.*;
import jogo.Jogada;
import jogo.Jogo;
import jogo.Retorno;

import org.junit.Before;
import org.junit.Test;

public class JogoTestes {

	Jogo jogo;
	
	@Before
	public void setUp() throws Exception {
		jogo = new Jogo();
	}

	@Test
	public void verSeAdivinhoGanhouJogoeTesteJogadaNula() {
		assertFalse(jogo.verSeAdivinhoGanhouJogo());
	}
	
	@Test
	public void verSeAdivinhoGanhouJogoeTesteJogadaEmQueAdivinhoGanha() {
		String [] retornoString = {"preto", "preto", "preto", "preto"};
		Retorno retorno = new Retorno();
		retorno.setRetorno(retornoString);
		Jogada jogada = new Jogada();
		jogada.setRetorno(retorno);
		jogo.setJogada(jogada);
		
		assertTrue(jogo.verSeAdivinhoGanhouJogo());
	}
	
	@Test
	public void verSeAdivinhoGanhouJogoeTesteJogadaEmQueAdivinhoPerde() {
		String [] retornoString = {"preto", "preto", "branco", "preto"};
		Retorno retorno = new Retorno();
		retorno.setRetorno(retornoString);
		Jogada jogada = new Jogada();
		jogada.setRetorno(retorno);
		jogo.setJogada(jogada);
		
		assertFalse(jogo.verSeAdivinhoGanhouJogo());
	}

}
