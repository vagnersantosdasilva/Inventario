package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

import Entidades.Maquina;

public class TesteDeAcessoArquivo {

	@Test
	public void test() {
		MockPersistencia DAO = new MockPersistencia();
		DAO.popularRepositorio();
		Maquina maquina = (Maquina)DAO.buscarMaquina("NAV-WIN1");
		assertEquals("NAV-WIN1",maquina.getHostname());
	}

}
