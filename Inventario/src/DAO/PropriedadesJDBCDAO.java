package DAO;

import java.io.IOException;
import java.util.List;

import Entidades.PropriedadesJDBC;

public class PropriedadesJDBCDAO 
{
	private  String caminhoAbsoluto;
	public PropriedadesJDBCDAO(String arquivo) 
	{
		this.caminhoAbsoluto=arquivo;
	}
	public  void setCaminho(String caminho) 
	{
		caminhoAbsoluto=caminho;
	}
	public  void gravarPropriedades(List lista,String caminho) 
	{
		try 
		{
			Util.Propriedades.escreverListaPropriedades(lista, caminho);
		}catch(IOException e)
		{
			System.out.println("Erro[PropriedadesSGBDDAO:gravarPropriedades]"+e.getMessage());
			e.printStackTrace();
		}
	}
	public  void gravarPropriedades(List lista) 
	{
		try 
		{
			Util.Propriedades.escreverListaPropriedades(lista, caminhoAbsoluto);
		}catch(IOException e)
		{
			System.out.println("Erro[PropriedadesSGBDDAO:gravarPropriedades]"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	public String obterURLConexao(String servidor,String sgbd) 
	{
		try 
		{
			if (sgbd.equals("mysql"))
			{
				
					String api=Util.Propriedades.lePropriedades("apiMySql", caminhoAbsoluto);
					String porta=Util.Propriedades.lePropriedades("portaMySql",caminhoAbsoluto);
					String urlConexao=api+"//"+servidor+":"+porta;
					
					return urlConexao;
			}
			if (sgbd.equals("postgresql"))
			{
				
					String api=Util.Propriedades.lePropriedades("apiPostgreSql", caminhoAbsoluto);
					String porta=Util.Propriedades.lePropriedades("portaPostgreSql",caminhoAbsoluto);
					String urlConexao=api+"//"+servidor+":"+porta;
					
					return urlConexao;
				
			}
			if (sgbd.equals("mssql"))
			{
				
					String api=Util.Propriedades.lePropriedades("apiMsSql", caminhoAbsoluto);
					String porta=Util.Propriedades.lePropriedades("portaMsSql",caminhoAbsoluto);
					String urlConexao=api+"//"+servidor+":"+porta;
					
					return urlConexao;
				
			}
			
			return "[vazio]";
	}	
	catch(IOException e)
	{
			System.out.println("Erro[ProrpiedadesJDBCDAO:obterURLConexcao]"+e.getMessage());
			e.printStackTrace();
	}
	return "[vazio]";	
		
	}

	public String obterDriver(String nomeBanco) {
		try 
		{
			if (nomeBanco.equals("mysql")) 
			{
				String driver = Util.Propriedades.lePropriedades("driverMySql", caminhoAbsoluto);
				return driver;
			}
			if(nomeBanco.equals("postgresql")) 
			{
				String driver = Util.Propriedades.lePropriedades("driverPostgreSql", caminhoAbsoluto);
				return driver;
			
			}
			if (nomeBanco.equals("mssql")) 
			{
				String driver = Util.Propriedades.lePropriedades("driverMsSql", caminhoAbsoluto);
				return driver;
			}
		}catch(IOException e) 
		{
			System.out.println("Erro[PropriedadesJDBCDAO:obterDriver]"+e.getMessage());
			e.printStackTrace();
		}
		return "[vazio]";
	}
	public PropriedadesJDBC obterPropriedades(String sgbd) {
		
		try 
		{
			if(sgbd.equals("mysql"))
			{
				PropriedadesJDBC propriedades = new PropriedadesJDBC();
				propriedades.setDriver(Util.Propriedades.lePropriedades("driverMySql", caminhoAbsoluto));
				propriedades.setApi(Util.Propriedades.lePropriedades("apiMySql", caminhoAbsoluto));
				propriedades.setPorta(Util.Propriedades.lePropriedades("portaMySql", caminhoAbsoluto));
				return propriedades;
			}
			if(sgbd.equals("postgresql")) 
			{
				PropriedadesJDBC propriedades = new PropriedadesJDBC();
				propriedades.setDriver(Util.Propriedades.lePropriedades("driverPostgreSQL", caminhoAbsoluto));
				propriedades.setApi(Util.Propriedades.lePropriedades("apiPostgreSQL", caminhoAbsoluto));
				propriedades.setPorta(Util.Propriedades.lePropriedades("portaPostgreSQL", caminhoAbsoluto));
				return propriedades;
			}
			if(sgbd.equals("mssql")) 
			{
				PropriedadesJDBC propriedades = new PropriedadesJDBC();
				propriedades.setDriver(Util.Propriedades.lePropriedades("driverMsSql", caminhoAbsoluto));
				propriedades.setApi(Util.Propriedades.lePropriedades("apiMsSql", caminhoAbsoluto));
				propriedades.setPorta(Util.Propriedades.lePropriedades("portaMsSql", caminhoAbsoluto));
				return propriedades;
			}
			
			return new PropriedadesJDBC();
		}catch(IOException e) 
		{
			System.out.println("Erro[ProrpiedadesJDBCDAO:obterPropriedades]"+e.getMessage());
			e.printStackTrace();
		}
		return new PropriedadesJDBC();
	}
	
	

	
	
}
