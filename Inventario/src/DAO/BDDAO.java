package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.BD;
import Entidades.CPU;

public class BDDAO 
{
	public boolean incluir (Connection conn,BD bd) 
	{
		
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement("insert into infobanco(sgbd,"
					+ "banco,"
					+ "ip,"
					+ "porta,"
					+ "frequencia,"
					+ "formato,"
					+ "data_backup,"
					+ "modo) "
					+ "values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, bd.getNomeSGBD());
			pstmt.setString(2, bd.getNomeBanco());
			pstmt.setString(3, bd.getIpBanco());
			pstmt.setString(4, bd.getPortaBanco());
			pstmt.setString(5, bd.getFrequenciaBackup());
			pstmt.setString(6, bd.getFormatoBackup());
			pstmt.setString(7, bd.getDataBackup());
			pstmt.setString(8, bd.getModoBackup());
			
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
			
		} catch (SQLException e) {

			System.out.println("Erro[BDDAO:incluir]:"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean excluir(Connection conn,BD bd)   
	{
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement("delete from infobanco ");
			int n = pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}
		catch(SQLException e) 
		{
			System.out.println("Erro[DBDAO:excluir] "+e.getMessage());
		}
		return false;
	}
	
	public boolean atualizar(Connection conn,BD bd)  
	{
		try {
			PreparedStatement pstmt = conn.prepareStatement
			(
				"update infobanco set sgbd=?,"
				+ "banco=?,"
				+ "ip=?,"
				+ "porta=?,"
				+ "frequencia=?, "
				+ "formato=?,"
				+ "data_backup=?,"
				+ "modo=?"
				
			);
				
			pstmt.setString(1, bd.getNomeSGBD());
			pstmt.setString(2, bd.getNomeBanco());
			pstmt.setString(3,bd.getIpBanco());
			pstmt.setString(4,bd.getPortaBanco());
			pstmt.setString(5,bd.getFrequenciaBackup());
			pstmt.setString(6,bd.getFormatoBackup());
			pstmt.setString(7,bd.getDataBackup());
			pstmt.setString(8,bd.getModoBackup());
			int n = pstmt.executeUpdate();
			pstmt.close();
				
			return n==1;
		}
		catch(SQLException e) 
		{
			System.out.println("Erro[DBDAO:atualizar]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	public BD buscar(Connection conn) throws SQLException 
	{
		BD bd = new BD();
		try 
		{
			PreparedStatement pstmt = conn.prepareStatement("select * from infobanco");
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				do
				{
					bd.setNomeSGBD(rs.getString("sgbd"));
					bd.setNomeBanco(rs.getString("banco"));
					bd.setIpBanco(rs.getString("ip"));
					bd.setPortaBanco(rs.getString("porta"));
					bd.setFrequenciaBackup(rs.getString("frequencia"));
					bd.setFormatoBackup(rs.getString("formato"));
					bd.setDataBackup(rs.getString("data_backup"));
					bd.setModoBackup(rs.getString("modo"));
				}
				while(rs.next());
				rs.close();
				pstmt.close();
				return bd;
			 }
		}catch(SQLException e) 
		{
			System.out.println("Erro[DBDAO:buscar]"+e.getMessage());
		}	
		return bd;
			
	}
	
	public boolean existeRegistro(Connection conn) {
		try
		{
			PreparedStatement query = conn.prepareStatement("select * from infobanco");
			ResultSet rs = query.executeQuery();
			int cont=0;
			if(rs.next()) 
			{
				do
				{
					cont=rs.getRow();
					
				}while(rs.next());
			rs.close();
			query.close();
			if (cont>0) return true;
			}
		}
		catch(SQLException e)
		{
			System.out.println("Erro[BDDAO:existe]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	public boolean backupMysql(Connection conn,String caminho) 
	{
		/*Salvar todas as bases */
		//mysqldump -u root -p -x -e -A > backup.sql
		//mysqldump -u root -p -x -e -A | gzip > backup.sql.zip
		//mysqldump -u root -p12345 -x -e -A | gzip > backup.sql.gz
		
		/*Salvar uma base especifica*/
		// mysqldump -u root -p -x -e -B nomeDaBase > nomeDoArquivo.sql
		
		/*Restaurar uma base especifica*/
		// mysql -u root -p –database=nomeDaBase < nomeDoArquivo.sql
		// mysql -u root -p12345 –database=nomeDaBase < nomeDoArquivo.sql
		
		
		return false;
		
	}

	
	
}
