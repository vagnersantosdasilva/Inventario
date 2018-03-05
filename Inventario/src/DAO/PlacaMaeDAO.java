package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import Entidades.PlacaMae;

public class PlacaMaeDAO {
	
	public boolean incluir(Connection conn,PlacaMae unidade) 
	{
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
			(
				"insert into placaMae (codigo_maquina,modelo,fabricante,serial_placa,status_drive) values(?,?,?,?,?) "
			);
			pstmt.setString(1,unidade.getCodigoMaquina());
			pstmt.setString(2, unidade.getModelo());
			pstmt.setString(3, unidade.getFabricante());
			pstmt.setString(4, unidade.getSerial());
			pstmt.setString(5, unidade.getStatus());
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[PlacaMaeDAO:incluir]"+e.getMessage());
		}
		return false;
	}
	
	public boolean excluir(Connection conn,String codigoMaquina) throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
			"delete from placaMae where codigo_maquina=?"
		);
	
		pstmt.setString(1, codigoMaquina);
		int n=pstmt.executeUpdate();
		pstmt.close();
		return n==1;
	}
	public boolean atualizarRegistro(Connection conn,PlacaMae unidade) 
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
					(
							"update placaMae set modelo=? , "
							+ "fabricante=?, "
							+ "serial_placa=?, "
							+ "status_drive = ? "
							+ "where codigo_maquina=?"
					);
			pstmt.setString(1, unidade.getModelo());
			pstmt.setString(2, unidade.getFabricante());
			pstmt.setString(3, unidade.getSerial());
			pstmt.setString(4, unidade.getStatus());
			pstmt.setString(5, unidade.getCodigoMaquina());
					
			int n = pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[PlacaMaeDAO:atualizarRegistro]:"+e.getMessage());
		}
		return false;
		
	}
	
	@SuppressWarnings("null")
	public PlacaMae obterPlacaMae(Connection conn,String codigoMaquina) throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
				"select * from placaMae where codigo_maquina=?"
		);
		pstmt.setString(1, codigoMaquina);
		ResultSet rs=pstmt.executeQuery();
		PlacaMae unidade = new PlacaMae();
		if (rs.next())
		{
			do
			{
				unidade.setCodigoMaquina(rs.getString("codigo_maquina"));
				unidade.setModelo(rs.getString("modelo"));
				unidade.setFabricante(rs.getString("fabricante"));
				unidade.setSerial(rs.getString("serial_placa"));
				unidade.setStatus(rs.getString("status_drive"));
			}
			while(rs.next());
			rs.close();
			pstmt.close();
			return unidade;
		}
		return new PlacaMae("?","?","?","?","?");
	 }
	
	//querys mais avançadas serão implementadas mais adiante.
	public List<PlacaMae> pesquisarEmPlacas(Connection conn, String likes) 
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
			(
				"select * from placaMae where like =?"
			);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				do
				{
					
				}
				while(rs.next());
				rs.close();
				pstmt.close();
				
			}
		}catch(SQLException e )
		{
			System.out.println("Erro[PlacaMaeDAO:pesquisarEmPlacas]"+e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean existe(Connection conn,String codigoMaquina)
	{
		try
		{
			PreparedStatement pstmt=conn.prepareStatement("select * from placaMae where codigo_maquina=?");
			pstmt.setString(1, codigoMaquina);
			
			ResultSet rs = pstmt.executeQuery();
			int cont=0;
			if(rs.next()) {
				do
				{
					cont=rs.getRow();
					
				}while(rs.next());
			rs.close();
			pstmt.close();
			
			if (cont>0) return true;
			}

		}
		catch(SQLException e)
		{
			System.out.println("Erro[PlacaMaeDAO:existe]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}
