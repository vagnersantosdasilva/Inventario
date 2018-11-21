package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.ParametrosEmail;

public class ParametrosEmailDAO 
{

	public ParametrosEmail getParametrosEmail(Connection conn) 
	{
		
		ParametrosEmail parametros = new ParametrosEmail();
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from parametros_email");
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				do
				{
					parametros.setNomeRemetente(rs.getString("nome_remetente"));
					parametros.setEmailOrigem(rs.getString("email_origem"));
					parametros.setPorta(rs.getInt("porta"));
					parametros.setSmtp(rs.getString("smtp"));
					parametros.setLogin(rs.getString("login"));
					parametros.setSenha(rs.getString("acesso"));
				}while(rs.next());
				pstmt.close();
				rs.close();
				System.out.println("Devolvido :"+parametros.getEmailOrigem());
				return parametros;
			}
		}	
		catch(SQLException e)
		{
			System.out.println("Erro[ParametrosEmailDAO:getParametrosEmail]"+e.getMessage());
			
		}
		return parametros;
	}
	
	public boolean incluirParametros(Connection conn,ParametrosEmail parametros)
	{
	
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement("insert into parametros_email (nome_remetente,email_origem,smtp,porta,login,acesso)"
					+ "values(?,?,?,?,?,?) ");
		
			pstmt.setString(1, parametros.getNomeRemetente());
			pstmt.setString(2, parametros.getEmailOrigem());
			pstmt.setString(3,parametros.getSmtp());
			pstmt.setInt(4, parametros.getPorta());
			pstmt.setString(5, parametros.getLogin());
			pstmt.setString(6, parametros.getSenha());
			
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		
		} 
		catch (SQLException e) 
		{
			System.out.println("Erro[ParametrosEmailDAO:incluirParametros]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	public boolean atualizarParametros(Connection conn,ParametrosEmail parametros)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("update parametros_email "
					+ "set nome_remetente=? ,"
					+ "email_origem= ?,"
					+ "smtp=?,"
					+ "porta=?,"
					+ "login=?,"
					+ "acesso=?");
			
			pstmt.setString(1, parametros.getNomeRemetente());
			pstmt.setString(2, parametros.getEmailOrigem());
			pstmt.setString(3,parametros.getSmtp());
			pstmt.setInt(4, parametros.getPorta());
			pstmt.setString(5, parametros.getLogin());
			pstmt.setString(6, parametros.getSenha());
			int n=pstmt.executeUpdate();
			return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[ParemetrosEmailDAO:atualizarParemetros]]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	public boolean excluirParametros (Connection conn)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("delete from parametros_email");
			int n=pstmt.executeUpdate();
			return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[ParemetrosEmailDAO:excluirParemetros]]"+e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean existeRegistro(Connection conn)
	{
		int cont=0;
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from parametros_email");
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				do{cont=cont+1;} while(rs.next());
			}
			if (cont>=1) return true;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[ParametrosEmailDAO:existeRegistro]"+e.getMessage());
			e.printStackTrace();;
		}
		return false;
	}
	
}

/*
 * create table parametros_email(nome_remetente varchar(30) not null,email_origem varchar(50) not null,smtp varchar(50) not null,porta int not null,login varchar(100) not null,acesso varchar(100) not null);
 * */
