package DAO;

import java.io.IOException;
import java.util.List;
import Entidades.ParametrosEmail;
public class PropriedadesSMTPDAO 
{
	private  String caminhoAbsoluto;
	public PropriedadesSMTPDAO(String arquivoPropriedades) {
		this.caminhoAbsoluto=arquivoPropriedades;
	}
	public  void setCaminho(String arquivoPropriedades) 
	{
		caminhoAbsoluto = arquivoPropriedades;
	}
	public  void gravarPropriedades(List lista) 
	{
		try {
			Util.Propriedades.escreverListaPropriedades(lista, caminhoAbsoluto);
		} catch (IOException e) {
			System.out.println("Erro[PropriedadesSMTPDAO:gravarPropriedades]"+e.getMessage());
			e.printStackTrace();
		}
	}
	public  void gravarPropriedades(List lista,String caminho) 
	{
		try {
			Util.Propriedades.escreverListaPropriedades(lista, caminho);
		} catch (IOException e) {
			System.out.println("Erro[PropriedadesSMTPDAO:gravarPropriedades]"+e.getMessage());
			e.printStackTrace();
		}
	}
	public  ParametrosEmail obterPropriedades() 
	{
		try 
		{
			ParametrosEmail propriedades = new ParametrosEmail();
			propriedades.setNomeRemetente("S.A.I");
			propriedades.setSmtp(Util.Propriedades.lePropriedades("servidorSMTP", caminhoAbsoluto));
			propriedades.setPorta(Util.Propriedades.lePropriedades("portaSMTP", caminhoAbsoluto));
			propriedades.setEmailOrigem(Util.Propriedades.lePropriedades("emailOrigem", caminhoAbsoluto));
			propriedades.setLogin(Util.Propriedades.lePropriedades("login", caminhoAbsoluto));
			propriedades.setSenha(Util.Propriedades.lePropriedades("senha", caminhoAbsoluto));
			
			return propriedades;
		}catch(IOException e) 
		{
			System.out.println("Erro[PropriedadesSMTPDAO:obterPropriedades]"+e.getMessage());
			e.printStackTrace();
		}
		return new ParametrosEmail();
	} 
	
	public  ParametrosEmail obterPropriedades(String caminho) 
	{
		System.out.println(caminho);
		try 
		{
			ParametrosEmail propriedades = new ParametrosEmail();
			propriedades.setNomeRemetente("S.A.I");
			propriedades.setSmtp(Util.Propriedades.lePropriedades("servidorSMTP", caminho));
			propriedades.setPorta(Util.Propriedades.lePropriedades("portaSMTP", caminho));
			propriedades.setEmailOrigem(Util.Propriedades.lePropriedades("emailOrigem", caminho));
			propriedades.setLogin(Util.Propriedades.lePropriedades("login", caminho));
			propriedades.setSenha(Util.Propriedades.lePropriedades("senha", caminho));
			
			return propriedades;
		}catch(IOException e) 
		{
			System.out.println("Erro[PropriedadesSMTPDAO:obterPropriedades]"+e.getMessage());
			e.printStackTrace();
		}
		return new ParametrosEmail();
	} 
}
