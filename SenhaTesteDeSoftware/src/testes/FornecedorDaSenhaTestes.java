package testes;

import static org.junit.Assert.*;
import jogo.FornecedorDaSenha;
import jogo.Jogada;
import jogo.Senha;
import jogo.Tentativa;

import org.junit.Before;
import org.junit.Test;

public class FornecedorDaSenhaTestes {

	FornecedorDaSenha fornecedor;
	
	@Before
	public void setUp() throws Exception {
		fornecedor = new FornecedorDaSenha();
	}

	@Test
	public void criarSenhaTesteNumeroDePinosInseridos() {
		fornecedor.criarSenha();

		assertEquals(4, fornecedor.getSenha().getPinosInseridos());
	}

	@Test
	public void criarSenhaTesteCoresDosPinosValidas() {
		fornecedor.criarSenha();
		
		String[] senha = fornecedor.getSenha().getSenha();
		boolean coresValidas = true;
		
		for (int i = 0; i < senha.length; i++) {
			coresValidas &= senha[i].compareTo("vermelho")==0|| senha[i].compareTo("azul")==0
							|| senha[i].compareTo("rosa")==0 || senha[i].compareTo("amarelo")==0
							|| senha[i].compareTo("roxo")==0 || senha[i].compareTo("verde")==0
							|| senha[i].compareTo("cinza")==0 || senha[i].compareTo("laranja")==0;
		}

		assertTrue(coresValidas);

	}

	
	
	@Test
	public void jogarTesteTentativaIgualASenha() {
		String [] tentativaString = {"vermelho", "rosa", "roxo", "verde"};
		Tentativa tentativa = new Tentativa();
		tentativa.setTentativa(tentativaString);
		Jogada jogada = new Jogada();
		jogada.setTentativa(tentativa);		
		fornecedor.setJogada(jogada);
		
		Senha senha = new Senha();
		senha.setSenha(tentativaString);
		senha.setPinosInseridos(4);
		fornecedor.setSenha(senha);
		
		fornecedor.jogar();
		
		String[] retorno = fornecedor.getJogada().getRetorno().getRetorno();
		boolean retornoValido=true;
		for (int i = 0; i < retorno.length; i++) {
			retornoValido &= retorno[i].compareTo("preto")==0;
		}
			
		assertTrue(retornoValido);
	}
	
	@Test
	public void jogarTesteTentativaDiferenteDaSenha() {
		String [] tentativaString = {"vermelho", "rosa", "roxo", "verde"};
		Tentativa tentativa = new Tentativa();
		tentativa.setTentativa(tentativaString);
		Jogada jogada = new Jogada();
		jogada.setTentativa(tentativa);		
		fornecedor.setJogada(jogada);
		
		String [] senhaString = { "rosa","vermelho", "roxo", "verde"};
		Senha senha = new Senha();
		senha.setSenha(senhaString);
		senha.setPinosInseridos(4);
		fornecedor.setSenha(senha);
		
		fornecedor.jogar();
		
		String[] retorno = fornecedor.getJogada().getRetorno().getRetorno();
		boolean retornoValido=true;
		for (int i = 0; i < retorno.length; i++) {
			
			if(i==2 || i==3){
				retornoValido &= retorno[i].compareTo("preto")==0;
			}else{
				retornoValido &= retorno[i].compareTo("branco")==0;
			}
		}
			
		assertTrue(retornoValido);
	}

	@Test (expected=Exception.class)
	public void jogarTesteTentativaNula() {
		
		Tentativa tentativa = new Tentativa();
		Jogada jogada = new Jogada();
		jogada.setTentativa(tentativa);		
		fornecedor.setJogada(jogada);
		
		String [] senhaString = {"vermelho", "rosa", "roxo", "verde"};
		Senha senha = new Senha();
		senha.setSenha(senhaString);
		senha.setPinosInseridos(4);
		fornecedor.setSenha(senha);
		
		fornecedor.jogar();
		
		fail("O array de valores da Tentativa é nulo, e nenhuma exceção foi lançada");
	}
}
