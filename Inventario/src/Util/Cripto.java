package Util;

import java.util.ArrayList;
import java.util.List;
public class Cripto 
{
	private int divisor1=2;
	private int divisor2=3;
	private int divisor3=5;
	private int divisor4=7;
	private int divisor5=13;
	private int divisor6=17;
	private int intervalo=1;
	String letras_ ="!@#$%&*?¨_=+-{}[]0987654321'aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUwWvVxXyYzZ |\\,.;:/()¹²³£¢¬º§´`~^ª°áÁéÉíÍóÓúÚàÀèÈìÌòÒùÙâÂêÊîÎôÔûÛãÃõÕçÇ<>»†€µ‡Š©®�"+'"';
	
	int divisores[] ={intervalo,divisor1,divisor2,divisor3,divisor4,divisor5,divisor6};
	
	/*Para maior eficiência use números de 2 a 33 para os divisores  e números pequenos para o intervalo*/
	public Cripto(int divisor1, int divisor2, int divisor3, int divisor4, int divisor5,int divisor6, int intervalo) 
	{
		divisores[0]=intervalo;
		divisores[1]=divisor1; 
		divisores[2]=divisor2; 
		divisores[3]=divisor3; 
		divisores[4]=divisor4; 
		divisores[5]=divisor5; 
		divisores[6]=divisor6;
	}
	
	public Cripto()	{}
	
	private String dqr(int indice,int divisor) 
	{
		StringBuilder sb = new StringBuilder();
		int quociente = indice/divisor;
		sb.append(letras_.charAt(quociente));
		int resto = indice%divisor;
		sb.append(letras_.charAt(resto));
		
		return sb.toString();
	}
	
	private char comporDQR(String cifra,int divisor) 
	{
		
		char quociente=cifra.charAt(0);
		char resto=cifra.charAt(1);
		int q = letras_.indexOf(quociente);
		int r = letras_.indexOf(resto);
		int letra=(divisor*q)+r;
		return letras_.charAt(letra);
	}
	
	
	public String cifrar(String frase) {
		
		int intervalo=divisores[0];
		int indiceDivisor=1;
		int divisor = divisores[indiceDivisor];
		int cont =0 ;
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<=frase.length()-1;i++)
		{
			if (indiceDivisor>=6) indiceDivisor=1;
			if (cont>=intervalo)
			{ 
				cont=0;
				indiceDivisor=indiceDivisor+1;
			}
			divisor=divisores[indiceDivisor];
			sb.append(cifrar(frase.charAt(i),divisor));
			cont=cont+1;
		}
		return sb.toString();
	}
	
	private String cifrar(char letra,int divisor)
	{
		int indice = letras_.indexOf(letra);
		return dqr(indice,divisor);
	}
	
	public String decifrar(String cifra) 
	{
		int cont=0;
		int i=0;
		StringBuilder sb = new StringBuilder();
		StringBuilder traduzido =new StringBuilder();
		List<String> fragmentos = new ArrayList<String>();
		do
		{
			if (cont<=2) sb.append(cifra.charAt(i));
			if (sb.length()==2)
			{ 
				cont=0;
				fragmentos.add(sb.toString());
				sb = new StringBuilder();
			}
			cont++;
			i++;
		}
		while(i<=cifra.length()-1);
		
		int indiceDivisor=1;
		cont=0;
		for (String cifras:fragmentos)
		{
			
			if (indiceDivisor>=6) indiceDivisor=1;
			if (cont>=intervalo)
			{ 
				cont=0;
				indiceDivisor=indiceDivisor+1;
			}
			cont=cont+1;
			
			traduzido.append(comporDQR(cifras,divisores[indiceDivisor]));
		}
		return traduzido.toString();
	}
	
	
}
