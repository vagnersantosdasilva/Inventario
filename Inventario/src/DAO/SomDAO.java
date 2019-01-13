package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.Som;

public class SomDAO 
{
	public boolean incluir(Connection conn,Som som)
	{
		try
		{
			PreparedStatement  pstmt =conn.prepareStatement
			("insert into som("
					+ "codigo_maquina,"
					+ "fabricante,"
					+ "data_instalacao,"
					+ "status) "
					+ "values(?,?,?,?)"
			);
			
			pstmt.setString(1, som.getCodigoMaquina());
			pstmt.setString(2, som.getFabricante());
			pstmt.setString(3, som.getDatainstalacao());
			pstmt.setString(4, som.getStatus());
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
			
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[SomDAO:incluir]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Connection conn,Som som)
	{
		try
		{
			PreparedStatement pstmt=conn.prepareStatement
					("update som set "
							+ "fabricante=? ,"
							+ "data_instalacao=?,"
							+ "status=? "
							+ "where codigo_maquina=?");
		
			pstmt.setString(1, som.getFabricante());
			pstmt.setString(2, som.getDatainstalacao());
			pstmt.setString(3, som.getStatus());
			pstmt.setString(4, som.getCodigoMaquina());
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[SomDAO:update]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean exlcuir(Connection conn,String codigoMaquina)
	{
		try
		{
			PreparedStatement pstmt=conn.prepareStatement("delete from som where codigo_maquina=?");
			pstmt.setString(1, codigoMaquina);
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}catch(SQLException e)
		{
			System.out.println("Erro:[SomDAO:excluir]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	public Som getSom(Connection conn,String codigoMaquina)
	{
		try
		{
			PreparedStatement pstmt=conn.prepareStatement("select * from som where codigo_maquina=?");
			pstmt.setString(1, codigoMaquina);
			ResultSet rs=pstmt.executeQuery();
			Som som = new Som();
			if(rs.next())
			{
				
				som.setCodigoMaquina(rs.getString("codigo_maquina"));
				
				som.setFabricante(rs.getString("fabricante"));
				som.setDatainstalacao(rs.getString("data_instalacao"));
				som.setStatus(rs.getString("status"));
			}
			rs.close();
			pstmt.close();
			return som;
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[SomDAO:getSom]"+e.getMessage());
			e.printStackTrace();
		}
		
		return (new Som());
	}

	public boolean existe(Connection conn, String codigoMaquina) {
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from som where codigo_maquina=?");
			pstmt.setString(1, codigoMaquina);
			ResultSet rs = pstmt.executeQuery();
			int cont=0;
			if (rs.next())
			{
				do
				{
					cont=rs.getRow();
				}
				while(rs.next());
				rs.close();
				pstmt.close();
			}
			if(cont>0)return true;
			return false;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[SomDAO:existe]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	
	}
	

}
