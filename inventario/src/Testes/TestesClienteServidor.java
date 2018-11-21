package Testes;

import static org.junit.Assert.*;

import org.junit.Test;

import Entidades.Maquina;


public class TestesClienteServidor {

	MockCliente mock;
	Maquina maquina;
	
	
	
	@Test
	public void testeConexaoClienteServidor()
	{
		MockCliente mock = new MockCliente();
		long inicio = System.currentTimeMillis();
		int porta=1050;
		int enviados=0;
		for(int i=0;i<=500;i++)
		{
			
			
			if (porta==1057) porta=1050;	
		
			mock.montarMaquinaTeste();
			mock.enviarMaquina("127.0.0.1", porta, mock.getMaquina());
			porta++;
			enviados++;
			
		}
		long intervalo = System.currentTimeMillis() - inicio;
		
		assertEquals(423,(intervalo/1000));
		System.out.println("Total de Enviados :"+enviados);
		
			
	}
	
}
