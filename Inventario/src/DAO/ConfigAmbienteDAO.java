package DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.google.gson.Gson;

import Entidades.BD;
import Entidades.PropriedadesJDBC;
import Entidades.PropriedadesSGBD;
import Entidades.Usuario;

public class ConfigAmbienteDAO 
{
	public boolean criarBaseDeDados(Connection conn,String nomeDaBase,String nomeDoSGBD) throws SQLException 
	{
		//criar exceção para - Base de dados já existente
		System.out.println("Nome do SGBD:"+nomeDoSGBD);
		if (nomeDoSGBD.equals("postgresql")) 
		{
			System.out.println("Base verificada :"+nomeDaBase);
			if (!existeBasePostgreSQL(conn, nomeDaBase)) 
			{
				Statement criador =conn.createStatement();
				criador.executeUpdate("CREATE DATABASE inventario;");
				//criador.executeUpdate("CREATE DATABASE IF NOT EXISTS inventario;");
				criador.close();
				System.out.println("Base Inventario criada com sucesso[PostgreSQL:inventario]");
				return true;
			}
			else System.out.println("Base de dados j� existente[PostgreSQL:Inventario]");
			return true;
		}
		if (nomeDoSGBD.equals("mysql")) 
		{
			Statement criador =conn.createStatement();
			criador.executeUpdate("CREATE DATABASE IF NOT EXISTS inventario;");
			criador.close();
			System.out.println("Base Inventario criada com sucesso[MySQL:inventario]");
			return true;
		}
		if(nomeDoSGBD.equals("mssql")) 
		{
			if (!existeBaseMsSQL(conn,nomeDaBase)) {
				Statement criador =conn.createStatement();
				criador.executeUpdate("CREATE DATABASE inventario");
				criador.close();
				System.out.println("Base Inventario criada com sucesso[MSSQL:inventario]");
				
			}return true;	
			
		}
		
		return false;
		
	}
	private boolean existeBaseMsSQL(Connection conn, String nomeDaBase) throws SQLException {
		PreparedStatement query = conn.prepareStatement("select name from sys.databases where name=?");
		query.setString(1, nomeDaBase);
		ResultSet rs = query.executeQuery();
		int contador=0;
		if (rs.next())
		{
			do
			{
				contador =rs.getRow();
			}
			while(rs.next());
		}
		rs.close();
		query.close();
		if (contador>0) return true;
		
		return false;
	}
	
	private boolean existeBasePostgreSQL(Connection conn,String nomeDaBase) throws SQLException
	{
		PreparedStatement query = conn.prepareStatement("select * from pg_database where datname=?");
		query.setString(1, nomeDaBase);
		ResultSet rs = query.executeQuery();
		int contador=0;
		if (rs.next())
		{
			do
			{
				contador =rs.getRow();
			}
			while(rs.next());
		}
		rs.close();
		query.close();
		if (contador>0) return true;
		
		return false;
	}
	
	
	public boolean excluirBaseDeDados(Connection conn,String nomeDaBase) throws SQLException
	{
		Statement destrutor =conn.createStatement();
		destrutor.executeUpdate("DROP DATABASE IF EXISTS inventario;");
		destrutor.close();
		return true;
	}
	
	public boolean criarTabelas(Connection conn,String arquivo) throws IOException, SQLException
	{
		Reader r = new FileReader(arquivo);
		BufferedReader br = new BufferedReader(r);
		String linha;
		

		while((linha=br.readLine())!=null)
		{
			if (linha.trim().length()>0) criarTabela(conn,linha); 
		}
		br.close();
		r.close();
		return true;
	}
	
	public boolean criarRoot(Connection conn,String email,String telefone) throws SQLException 
	{
		if (existeRoot(conn)) return false ;
		Usuario root = new Usuario();
		Usuarios dao = new Usuarios();
		if (telefone==null) telefone ="";
		if (email==null) email ="";
		root.setChaveAcesso("default");  //criar um gerador aleatório de senhas
		root.setEmail(email);
		root.setGrupoAcesso("admin");
		root.setNomeUsuario("admin");
		root.setTelefone(telefone);
		if (dao.incluir(conn, root)) return true;
		return false;
	}
	
	private boolean existeRoot(Connection conn) 
	{
		Usuarios usuarios = new Usuarios();
		if (usuarios.existeUsuario(conn,"admin")) return true;
		return false;
	}
	
	private  boolean criarTabela(Connection conn,String sql) throws SQLException
	{
		/*Aparentemente não é possível enviar mais de um create na mesma statement 
		 * Então será criado um statement para cada tabela */
		
		Statement criador = conn.createStatement();
		criador.executeUpdate(sql);
		criador.close();
		return true;
	}
	
	public boolean gravarInfoBanco(Connection conn,BD infoBanco) 
	{
		BDDAO dao = new BDDAO();
		return dao.incluir(conn, infoBanco);
	}
	
	public boolean exculirTabelas(Connection conn,Gson tabela) 
	{
		return true;
	}
	public boolean gravarInfoBanco(Connection conn, PropriedadesSGBDDAO sgbddao, PropriedadesJDBCDAO jdbcdao) throws SQLException {
		
		PropriedadesSGBD sgbd = sgbddao.obterPropriedades();
		PropriedadesJDBC jdbc = jdbcdao.obterPropriedades(sgbd.getSGBD());
		
		
		BD bd = new BD(sgbd.getSGBD(),"inventario",sgbd.getHost(),jdbc.getPorta(),"mensalmente","automatico","txt","00-00-0000");
		BD bd_ = new BD();
		
		BDDAO dao = new BDDAO() ;
		if (dao.existeRegistro(conn)) 
		{
			bd_ = dao.buscar(conn);
			if (!(bd_.getNomeSGBD().equals(bd.getNomeSGBD()))) 
			{
				dao.atualizar(conn, bd);
				return true;
			}
			else 
			{
				bd.setDataBackup((bd_.getDataBackup()));
				dao.atualizar(conn, bd);
				return true;
			}
		}
		
		if (dao.incluir(conn, bd)) return true;
		return false;
	}
	
	
}
