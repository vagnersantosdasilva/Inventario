package Testes;

import static org.junit.Assert.*;
import org.junit.Test;
import Util.Cripto;
public class TesteCriptografia {
	@Test
	public void testeDeCaractere() {
		Cripto cripto = new Cripto();
		//assertEquals(cripto.cifrar('K',2),"A@");
		//System.out.println(cripto.cifrar("Uma frase simples"));
		//System.out.println(cripto.cifrar("Uma frase simples\\"));
	}
	
	@Test
	public void testeCifrarDecifrarSimples()
	{
		Cripto cripto = new Cripto();
		//assertEquals("b",cripto.decifrar(";@"));
		//assertEquals("Uma frase simples",cripto.decifrar("g!{#$#}##@$!&#=$$%?;$#-!:@*&$!@:a#"));
		//assertEquals("Uma frase simples\\",cripto.decifrar("g!{#$#}##@$!&#=$$%?;$#-!:@*&$!@:a#b#"));
	}
	
	@Test
	public void testeCifrarDecifrarComChaveDeNumerosPrimos()
	{
		Cripto cripto0= new Cripto(2,3,17,21,5,7,1);
		String cifrado=cripto0.cifrar("Uma frase mais longa");
		String decifrado0=cripto0.decifrar(cifrado);
		
		Cripto cripto1 = new Cripto(2,3,17,21,5,7,1);
		String decifrado1 = cripto1.decifrar(cifrado);
		System.out.println(cifrado);
		assertEquals("Uma frase mais longa",decifrado0);
		assertEquals("Uma frase mais longa",decifrado1);
		assertEquals(decifrado0,decifrado1);
	}
	
	@Test
	public void testeCifrarDecifrarComNumeroPositivoQualquer()
	{
		Cripto cripto0= new Cripto(33,10,20,26,5,30,1);
		String cifrado=cripto0.cifrar("Uma frase mais longa");
		//String decifrado0=cripto0.decifrar(cifrado);
		System.out.println(cifrado);
		//System.out.println("Ultimo numero :"+cripto0.getTamanhoAlfabeto());
		assertEquals("Uma frase mais longa",cripto0.decifrar(cifrado));
	}
	
	
}
