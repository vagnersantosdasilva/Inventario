package Testes;

import static org.junit.Assert.*;
import org.junit.Test;
import Util.Cripto;

public class TestesDeCriptografia {
/*
	@Test
	public void TesteSaidaf2() {
		Cripto cripto = new Cripto();
		
		//assertEquals("baa" ,cripto.dqr(0,2));
		//assertEquals("baA" ,cripto.dqr(1,2));
		//assertEquals("bAa" ,cripto.dqr(2,2));
		System.out.println("");
		System.out.println("Fator 2");
		for (int i=0;i<=68;i++) 
		{
			System.out.print(cripto.dqr(i, 2)+"	");
			
		}
		System.out.println("");
		System.out.println("Fator 3");
		for (int i=0;i<=68;i++) 
		{
			System.out.print(cripto.dqr(i, 3)+"	");
			
		}
		System.out.println("");
		System.out.println("Fator 5");
		for (int i=0;i<=68;i++) 
		{
			System.out.print(cripto.dqr(i, 5)+"	");
		}
		System.out.println("");
		System.out.println("Fator 7");
		for (int i=0;i<=68;i++) 
		{
			System.out.print(cripto.dqr(i, 7)+"	");
		}
		System.out.println("");
		System.out.println("Fator 11");
		for (int i=0;i<=68;i++) 
		{
			System.out.print(cripto.dqr(i, 11)+"	");
		}
		System.out.println("");
		System.out.println("Descriptografado...");
		for (int i=0;i<=68;i++) 
		{
			System.out.print(cripto.comporDQR(cripto.dqr(i, 11))+"	");
		}
	}
	*/
	@Test
	public void TestCriptografiaSimplesDeFrase() 
	{
		Cripto cripto = new Cripto();
		String cifrado = cripto.cifrar("Minha prima e bonita");
		assertEquals("minha prima e bonita",cripto.decifrar(cifrado));
		
	}

}
