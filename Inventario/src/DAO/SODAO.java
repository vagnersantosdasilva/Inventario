package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.SO;

public class SODAO {
	
	public boolean incluir(Connection conn, SO unidade) 
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
			("insert into sistemaOperacional ("
							+ "codigo_maquina,"
							+ "hostname,"
							+ "nome,"
							+ "arquitetura,"
							+ "versao,"
							+ "atualizacao,"
							+ "dataInstalacao) "
							+ "values(?,?,?,?,?,?,?)"
			);
			pstmt.setString(1,unidade.getCodigoMaquina());
			pstmt.setString(2, unidade.getHostname());
			pstmt.setString(3,unidade.getNome());
			pstmt.setString(4, unidade.getArquitetura());
			pstmt.setString(5, unidade.getVersao());
			pstmt.setString(6,unidade.getAtualizacao());
			pstmt.setString(7, unidade.getDataInstalacao());
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[SODAO:incluir]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean excluirTodos(Connection conn,String codigoMaquina) 
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
			(
				"delete from sistemaOperacional where codigo_maquina=? "
			);
			pstmt.setString(1, codigoMaquina);
			int n = pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[SODAO:excluir]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean excluirUm(Connection conn,String codigoMaquina)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
			(
				"delete from sistemaOperacional where codigo_maquina=? "
			);
			pstmt.setString(1, codigoMaquina);
			int n=pstmt.executeUpdate();
			return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[SODAO:excluirUm]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean atualizarRegistro(Connection conn,SO unidade)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
			(
					"update sistemaOperacional set "
							+ "nome=?,"
							+ "hostname=?,"
							+ "arquitetura=?,"
							+ "versao=?,"
							+ "atualizacao=?,"
							+ "dataInstalacao=? "
							+ "where codigo_maquina=? "			
			);
			pstmt.setString(1,unidade.getNome());
			pstmt.setString(2, unidade.getHostname());
			pstmt.setString(3, unidade.getArquitetura());
			pstmt.setString(4, unidade.getVersao());
			pstmt.setString(5, unidade.getAtualizacao());
			pstmt.setString(6, unidade.getDataInstalacao());
			pstmt.setString(7, unidade.getCodigoMaquina());
			int n=pstmt.executeUpdate();
			return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[SODAO:atualizarRegistro]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	
	public SO obterSistema(Connection conn,String codigoMaquina) throws SQLException
	{
		SO sistema=new SO();
		try
		{
			PreparedStatement pstmt =  conn.prepareStatement
			(
				"select * from sistemaOperacional where codigo_maquina=?"
			);
			pstmt.setString(1, codigoMaquina);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				do{
					sistema.setCodigoMaquina(rs.getString("codigo_maquina"));
					sistema.setHostname(rs.getString("hostname"));
					sistema.setNome(rs.getString("nome"));
					sistema.setArquitetura(rs.getString("arquitetura"));
					sistema.setVersao(rs.getString("versao"));
					sistema.setAtualizacao(rs.getString("atualizacao"));
					sistema.setDataInstalacao(rs.getString("dataInstalacao"));
					
				   }
				while(rs.next());
			}
			rs.close();
			pstmt.close();
			return sistema;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[SODAO:obterSistemas]"+e.getMessage());
			e.printStackTrace();
		}
		return sistema;
	}

	public String obterCodigoMaquinaPorHostName(Connection conn, String hostname) {
		
		String codigoMaquina=null;
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from sistemaOperacional where hostname=?");
			pstmt.setString(1, hostname);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				do
				{
					codigoMaquina=rs.getString("codigo_maquina");
				}while(rs.next());
				
			}
			rs.close();
			pstmt.close();
			return codigoMaquina;
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[SODAO:obterCodigoMaquinaPorHostName]"+e.getMessage());
			e.printStackTrace();
		}
		
		return codigoMaquina;
	}
	
	public int obterTotalDeRegistros(Connection conn)
	{
		int contador =0;
		try {
			PreparedStatement pstmt = conn.prepareStatement("select codigo_maquina from sistemaOperacional");
			ResultSet rs=pstmt.executeQuery();
			
			if (rs.next())
			{
				do 
				{
					//System.out.println(rs.getInt("count"));
					contador=contador+1;
				}while(rs.next());
				rs.close();
				pstmt.close();
				return contador;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro[SODAO:obterTotalDeRegistros]"+e.getMessage());
			e.printStackTrace();
		}
		return -1;
	}

	public boolean existe(Connection conn, String codigoMaquina) {
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select codigo_maquina from sistemaOperacional where codigo_maquina=?");
			
			pstmt.setString(1, codigoMaquina);
			ResultSet rs=pstmt.executeQuery();
			int contador=0;
			if(rs.next())
			{
				do
				{
					contador++;
				}
				
				while(rs.next());
				pstmt.close();
				rs.close();
				
			}
			if (contador>0) return true;
			
		}
		catch(SQLException e)
		{
			System.out.println("ERRO:[SODOA:existe]"+e.getMessage());
			e.printStackTrace();
		}
		
		
		return false;
	}
	
}
