package DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import Entidades.Propriedades;
import Entidades.PropriedadesJDBC;
import Util.Cripto;

public class ServicoDAO 
{
	
	private String usuario;
	private String senha;
	private String servidor;
	private String porta;
	private String api;
	private String nomeDoBanco;
	private String sgbd;
	private String driver;
	private String urlConexao;
	private Connection conn=null;
	private static ServicoDAO instancia;
	
	
	private ServicoDAO(Propriedades propriedades) 
	{
		this.usuario =propriedades.getUsuario();
		this.senha=propriedades.getSenha();
		this.servidor=propriedades.getServidor();
		this.porta=propriedades.getPorta();
		this.api=propriedades.getApi();
		this.nomeDoBanco=propriedades.getNomeDoBanco();
		this.sgbd=propriedades.getSgbd();
		this.driver=propriedades.getDriver();
		this.urlConexao=obterUrLConexao();
		System.out.println(this.urlConexao);
	}
	
	//Garantir uma unica instancia que acessa o banco para toda aplicacao
	public static ServicoDAO getInstace(Propriedades propriedades) 
	{
		if(instancia==null)
		{
			synchronized(ServicoDAO.class)
			{  //possiveis solicitações simultaneas são tratadas
				if(instancia==null)
				{
					instancia=new ServicoDAO(propriedades);
				}
							
			}
		}
	return instancia;
	}
		
	
	private String obterUrLConexao() 
	{
		Cripto cripto = new Cripto(3,2,5,7,13,21,1);
		if (sgbd.equals("mssql")) {
			//"jdbc:sqlserver://"+enderecoBanco+":1433;databaseName=inventario;user="+nomeUsuario+";password="+senha
			return api+servidor+porta+";databaseName="+nomeDoBanco+";user="+usuario+";password="+cripto.decifrar(senha);
		}
		if (sgbd.equals("oracle")) {
			
		}
		//return api+servidor+porta+"/"+nomeDoBanco+","+usuario+","+cripto.decifrar(senha);
		return api+servidor+porta+"/"+nomeDoBanco;
	}
	
	public Connection obterConexao() throws ClassNotFoundException, SQLException
	{
		System.out.println("driver obtido : "+driver);
		System.out.println("URL           : "+urlConexao);
		Class.forName(driver);
		Cripto cripto = new Cripto(3,2,5,7,13,21,1);
		
		if (sgbd.equals("mssql")) 
		{
			conn = DriverManager.getConnection(urlConexao);
			conn.setAutoCommit(false);
			return conn;
		}
		conn = DriverManager.getConnection(urlConexao,usuario,cripto.decifrar(senha));
		conn.setAutoCommit(false);
		return conn;
	}

}
