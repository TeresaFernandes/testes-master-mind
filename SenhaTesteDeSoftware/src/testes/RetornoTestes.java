package testes;

import static org.junit.Assert.*;
import jogo.CorInvalidaException;
import jogo.PosicaoInvalidaException;
import jogo.Retorno;

import org.junit.Before;
import org.junit.Test;

public class RetornoTestes {

	Retorno retorno;
	
	@Before
	public void setUp() throws Exception {
		retorno = new Retorno();
	}

	@Test (expected=CorInvalidaException.class)
	public void adicionarPinoTestePinoCorBrancoQuantidadePinosNegativo() throws CorInvalidaException {
		retorno.setPinosInseridos(-1);
		retorno.adicionarPino("branco");
		
		fail("A quantidade de pinos inserido no retorno é negativo, mas não foi lançada nenhuma exceção");
	}
	
	@Test
	public void adicionarPinoTestePinoCorPretoQuantidadePinosZero() throws CorInvalidaException {
		retorno.setPinosInseridos(0);
		retorno.adicionarPino("preto");
		
		assertEquals("preto", retorno.getRetorno()[0]);
	}
	
	@Test
	public void adicionarPinoTestePinoCorBrancoQuantidadePinosTres() throws CorInvalidaException {
		String [] retornoString = {"preto", "branco", "nenhum", "nenhum"};
		retorno.setRetorno(retornoString);		
		retorno.setPinosInseridos(3);
		retorno.adicionarPino("branco");
		
		assertEquals("branco", retorno.getRetorno()[3]);
	}
	
	@Test
	public void adicionarPinoTestePinoCorAmareloQuantidadePinosTres() {
		try{
			String [] retornoString = {"preto", "branco", "nenhum", "nenhum"};
			retorno.setRetorno(retornoString);		
			retorno.setPinosInseridos(3);
			retorno.adicionarPino("amarelo");
			
			fail("Cor 'amarelo' é invalida, mas nenhuma exceção foi lançada");
		}catch(CorInvalidaException e){
			
		}
	}
	
	@Test (expected=CorInvalidaException.class)
	public void adicionarPinoTestePinoCorRoxoQuantidadePinosQuatro() throws CorInvalidaException {
		String [] retornoString = {"preto", "branco", "branco", "branco"};
		retorno.setRetorno(retornoString);		
		retorno.setPinosInseridos(5);
		retorno.adicionarPino("branco");
		
		fail("A quantidade de pinos inserido no retorno excede o tamanho do array, mas não foi lançada nenhuma exceção");
	}
	
	@Test  (expected=PosicaoInvalidaException.class)
	public void getPinoTestePosicaoNegativa() throws PosicaoInvalidaException{
		String [] retornoString = {"preto", "preto", "nenhum", "nenhum"};
		retorno.setRetorno(retornoString);
		
		retorno.getPino(-1);
		fail("O numero da posição não está no intervalo 0<=posição<=3");
	}
	
	@Test
	public void getPinoTestePosicaoEntreZeroETres() throws PosicaoInvalidaException {
		
		String [] retornoString = {"preto", "preto", "branco", "branco"};
		retorno.setRetorno(retornoString);
		
		assertEquals("branco",retorno.getPino(3));
	}
	
	@Test  (expected=PosicaoInvalidaException.class)
	public void getPinoTestePosicaoMaiorQueTres() throws PosicaoInvalidaException {
		String [] retornoString = {"preto", "preto", "branco", "branco"};
		retorno.setRetorno(retornoString);
		
		retorno.getPino(5);
		fail("O numero da posição não está no intervalo 0<=posição<=3");
	}
	
	@Test
	public void getPinoTestePosicaoIgualZero() throws PosicaoInvalidaException {
		
		String [] retornoString = {"nenhum", "nenhum", "nenhum", "nenhum"};
		retorno.setRetorno(retornoString);
		
		assertEquals("nenhum",retorno.getPino(0));
	}

}
