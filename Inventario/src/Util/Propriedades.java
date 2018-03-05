package Util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Properties;

public class Propriedades {
	
	private String ipDeServidor;
	private String portaDeServidor;
	private String nomeBanco;
	private String nomeSGBD;
	private String nomeDeAcesso;
	private String chaveDeAcesso;
	private String codigoDeTexto;
	
	
	

	public static String lePropriedades(String propriedade) throws IOException{

		Properties prop=new Properties();
		FileInputStream fis = new FileInputStream("propriedades.txt");
		prop.load(fis);
		String valorDeRetorno=prop.getProperty(propriedade);
		fis.close();
		return valorDeRetorno;

	}

	public static void escrevePropriedades(String chave,String valor)throws IOException{
		Properties prop=new Properties();
		FileOutputStream fos = new FileOutputStream("propriedades.txt");
		prop.setProperty(chave,valor);
		prop.store(fos,"");
	}
	
	public static String codificarMD5(String sentenca){
		String codificado=null;
		MessageDigest md=null;
		try
		{
			md=MessageDigest.getInstance("MD5");
			BigInteger hash;
			hash = new BigInteger(1,md.digest(sentenca.getBytes("UTF-8")));
			codificado = hash.toString(16);
			return codificado;
			
		}catch(NoSuchAlgorithmException e)
		{
			System.out.println("Erro [Propriedades(MD5)]");
			System.out.println(e.getMessage());
		}catch(UnsupportedEncodingException e)
		{
			System.out.println("Erro [Propriedades(MD5)]");
			System.out.println(e.getMessage());
		}
		
		return codificado;
	}

}
