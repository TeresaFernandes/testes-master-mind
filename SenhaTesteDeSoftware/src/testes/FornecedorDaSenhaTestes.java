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
			coresValidas &= senha[i].equals("vermelho")|| senha[i].equals("azul")
							|| senha[i].equals("rosa") || senha[i].equals("amarelo")
							|| senha[i].equals("roxo") || senha[i].equals("verde")
							|| senha[i].equals("cinza") || senha[i].equals("laranja");
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
			retornoValido &= retorno[i].equals("preto");
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
				retornoValido &= retorno[i].equals("preto");
			}else{
				retornoValido &= retorno[i].equals("branco");
			}
		}
			
		assertTrue(retornoValido);
	}

	@Test
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
