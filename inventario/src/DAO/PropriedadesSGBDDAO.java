package DAO;

import java.io.IOException;
import java.util.List;

import Entidades.PropriedadesSGBD;

public class PropriedadesSGBDDAO 
{
	
	private  String caminhoAbsoluto;
	
	public PropriedadesSGBDDAO(String arquivo) 
	{
		this.caminhoAbsoluto=arquivo;
	}
	
	public  void setCaminho(String caminho) 
	{
		caminhoAbsoluto = caminho;
	}
	
	
	public  void gravarPropriedades(List lista) 
	{
		try{
			Util.Propriedades.escreverListaPropriedades(lista, caminhoAbsoluto);
		}catch(IOException e) 
		{
			System.out.println("Erro[PropriedadesSGBDDAO: gravarPropriedades]"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public  void gravarPropriedades(List lista,String caminho) 
	{
		try{
			Util.Propriedades.escreverListaPropriedades(lista, caminho);
		}catch(IOException e) 
		{
			System.out.println("Erro[PropriedadesSGBDDAO: gravarPropriedades]"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public  PropriedadesSGBD  obterPropriedades() 
	{
		try 
		{
			PropriedadesSGBD propriedades = new PropriedadesSGBD();
			propriedades.setHost(Util.Propriedades.lePropriedades("servidor",caminhoAbsoluto));
			propriedades.setNomeDoBanco(Util.Propriedades.lePropriedades("nomeDoBanco",caminhoAbsoluto));
			propriedades.setSGBD(Util.Propriedades.lePropriedades("sgbdescolhido",caminhoAbsoluto));
			propriedades.setUsuario(Util.Propriedades.lePropriedades("usuario",caminhoAbsoluto));
			propriedades.setSenha(Util.Propriedades.lePropriedades("senha",caminhoAbsoluto));
			propriedades.setCodificacao(Util.Propriedades.lePropriedades("codificacao",caminhoAbsoluto));
			return propriedades;
		}	
		catch(IOException e) 
		{
			System.out.println("Erro[PropriedadesSGBDDAO: obterPropriedades]"+e.getMessage());
			e.printStackTrace();
		}
		return new PropriedadesSGBD();
	} 
	public  PropriedadesSGBD  obterPropriedades(String caminho) 
	{
		try 
		{
			PropriedadesSGBD propriedades = new PropriedadesSGBD();
			propriedades.setHost(Util.Propriedades.lePropriedades("servidor",caminho));
			propriedades.setNomeDoBanco(Util.Propriedades.lePropriedades("nomeDoBanco",caminho));
			propriedades.setSGBD(Util.Propriedades.lePropriedades("sgbdescolhido",caminho));
			propriedades.setUsuario(Util.Propriedades.lePropriedades("usuario",caminho));
			propriedades.setSenha(Util.Propriedades.lePropriedades("senha",caminho));
			propriedades.setCodificacao(Util.Propriedades.lePropriedades("codificacao",caminho));
			
			System.out.println("Teste envio : "+propriedades.getHost());
			return propriedades;
		}	
		catch(IOException e) 
		{
			System.out.println("Erro[PropriedadesSGBDDAO: obterPropriedades]"+e.getMessage());
			e.printStackTrace();
		}
		return new PropriedadesSGBD();
		
	} 
}
