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
	
	private String obterUrLConexao() {
		Cripto cripto = new Cripto(3,2,5,7,13,21,1);
		if (sgbd.equals("mssql")) {
			//"jdbc:sqlserver://"+enderecoBanco+":1433;databaseName=inventario;user="+nomeUsuario+";password="+senha
			return api+servidor+porta+";databaseName="+nomeDoBanco+";user="+usuario+";password="+cripto.decifrar(senha);
		}
		return api+servidor+porta+"/"+nomeDoBanco+","+usuario+","+cripto.decifrar(senha);
	}
	private ServicoDAO(String caminho)
	{
		try
		{
			Properties props = new Properties();
			FileInputStream arquivoPropriedades = new FileInputStream(caminho);
			props.load(arquivoPropriedades);
			this.usuario=props.getProperty("usuario");
			this.senha=props.getProperty("senha");
			this.sgbd=props.getProperty("sgbdescolhido");
			this.servidor = props.getProperty("servidor");
			this.nomeDoBanco = props.getProperty("nomeDoBanco");
			
			System.out.println("usuario :"+usuario);
			System.out.println("senha :"+senha);
			System.out.println("sgbd :"+sgbd);
			System.out.println("servidor :"+servidor);
			System.out.println("nome do banco :"+nomeDoBanco);
			if (sgbd.equals("mysql"))
			{
				 this.porta = props.getProperty("portaMySql");
				 this.api = props.getProperty("apiMySql");
				 this.driver = props.getProperty("driverMySql");
				 this.urlConexao=api+servidor+porta+nomeDoBanco;
				 System.out.println(this.urlConexao);
			}
			
			if (sgbd.equals("postgresql"))
			{	
				this.porta=props.getProperty("portaPostgreSql");
				this.api=props.getProperty("apiPostgreSql");
				this.driver = props.getProperty("driverPostgreSql");
				this.urlConexao = api+servidor+porta+nomeDoBanco;
			}
			if(sgbd.equals("mssql")) {
				this.porta=props.getProperty("portaMsSql");
				this.api=props.getProperty("apiMsSql");
				this.driver = props.getProperty("driverMsSql");
				this.urlConexao = api+servidor+porta+";databaseName="+nomeDoBanco;
			}
			arquivoPropriedades.close();
		}catch(Exception e)
		{
			System.out.println("SerivoDAO[Construtor]: "+e.getMessage());
		}
	}
	//Objetivo é garantir uma única instância que acessa o banco para toda aplicação
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
	
	
	//Objetivo é garantir uma única instância que acessa o banco para toda aplicação
	public static ServicoDAO getInstace(String caminho) 
	{
		if(instancia==null)
		{
			synchronized(ServicoDAO.class)
			{  //possiveis solicitações simultaneas são tratadas
				if(instancia==null)
				{
					instancia=new ServicoDAO(caminho);
				}
					
			}
		}
			return instancia;
		}
	
	
	public Connection obterConexao() throws ClassNotFoundException, SQLException
	{
		System.out.println("driver obtido : "+driver);
		Class.forName(driver);
		conn = DriverManager.getConnection(urlConexao);
		conn.setAutoCommit(false);
		return conn;
	}

}
