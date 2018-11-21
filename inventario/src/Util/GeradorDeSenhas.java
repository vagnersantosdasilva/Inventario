package Util;

import java.util.Random;

public class GeradorDeSenhas 
{
	
	
	public static String gerarSenha(int tamanho) 
	{
		char[] alfabetoMin = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','y','w','z'};
		char[] alfabetoMax = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','X','Y','W','Z'};
		char[] charEspeciais= {'!','@','#','$','%','&','*','_'};
		StringBuilder sb = new StringBuilder();
		Random aleatorio = new Random();
		for (int i=0;i<=tamanho-2;i++) 
		{
			if (aleatorio.nextInt(2)%2!=0)
			{
				sb.append(alfabetoMin[aleatorio.nextInt(26)]);
			}
			else {sb.append(alfabetoMax[aleatorio.nextInt(26)]);}
		}
		sb.append(charEspeciais[aleatorio.nextInt(7)]);
		System.out.println(sb.toString());
		return sb.toString();
	}
}
