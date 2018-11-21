package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestesGeradorDeSenhas {

	@Test
	public void TesteGeradorSequencia() {
		assertEquals(Util.GeradorDeSenhas.gerarSenha(6).length(),6);
		assertEquals(Util.GeradorDeSenhas.gerarSenha(8).length(),8);
	}

}
