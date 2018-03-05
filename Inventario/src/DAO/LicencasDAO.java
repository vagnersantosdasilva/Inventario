package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Licenca;

public class LicencasDAO 
{
	
	public boolean incluirLista(Connection conn,List<Licenca> licencas) throws SQLException
	{
		for(Licenca licenca :licencas)
		{
			if (existe(conn,licenca))
			{ 
				atualizarRegistro(conn,licenca);
			}
			else
			{
				incluir(conn,licenca);
			}
		}
		return true;
	}
	public boolean excluirLista(Connection conn,List<Licenca>licencas)
	{
		for(Licenca licenca:licencas)
		{
			try
			{
				if(existe(conn,licenca))
				{
					excluir(conn, licenca);
				}
				else
				{
					System.out.println("LicencasDAO[.excluirLista]: Registro não encontrado ->"+licenca.getNomeSoftware());
				}
			}
			catch(SQLException e)
			{
				System.out.println("LicencaDAO[.excluirLista]:"+e.getMessage());
				return false;
			}
			
		}
		return true;
	}
	
	public boolean incluir(Connection conn,Licenca licenca)throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
				"insert into licencas("
				+ "codigo_maquina,"
				+ "software,"
				+ "chave,"
				+ "data_expiracao) "
				+ "values(?,?,?,?) "
				
		);
		pstmt.setString(1, licenca.getCodigoMaquina());
		pstmt.setString(2, licenca.getNomeSoftware());
		pstmt.setString(3, licenca.getChave());
		pstmt.setString(4, licenca.getDataExpiracao());
		int n=pstmt.executeUpdate();
		pstmt.close();
		return n==1;
		
	}
	public boolean atualizarRegistro(Connection conn,Licenca licenca)throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
			"update licencas set chave=?, "
			+ "data_expiracao=? "
			+ "where codigo_maquina=? and "
			+ "software=? "
		);
		pstmt.setString(1, licenca.getChave());
		pstmt.setString(2, licenca.getDataExpiracao());
		pstmt.setString(3,licenca.getCodigoMaquina());
		pstmt.setString(4, licenca.getNomeSoftware());
		int n=pstmt.executeUpdate();
		pstmt.close();
		return n==1;
		
	}
	private boolean existe(Connection conn,Licenca licenca)throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
			"select * from licencas where codigo_maquina = ? and software = ?"
		);
		
		pstmt.setString(1,licenca.getCodigoMaquina());
		pstmt.setString(2,licenca.getNomeSoftware());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) 
		{
			System.out.println("existe");
			rs.close();
			pstmt.close();
			return true;
		}
		pstmt.close();
		rs.close();
		return false;
	}
	public boolean excluir(Connection conn,Licenca licenca) throws SQLException
	{
		PreparedStatement pstmt=conn.prepareStatement
		(
				"delete from licencas "
				+ "where codigo_maquina=? and "
				+ "software=?"
		);
		pstmt.setString(1, licenca.getCodigoMaquina());
		pstmt.setString(2, licenca.getNomeSoftware());
		int n=pstmt.executeUpdate();
		pstmt.close();
		return n==1;
	}
	
	public List obterListaLicencas(Connection conn,String codigoMaquina)throws SQLException
	{
		List<Licenca> lista = new ArrayList<Licenca>();
		PreparedStatement pstmt=conn.prepareStatement
		(
				"select * from licencas where codigo_maquina=?"
		);
		pstmt.setString(1,codigoMaquina);
		ResultSet rs = pstmt.executeQuery();
		
		
		
		if(rs.next()) 
		{
			do
			{
				Licenca licenca = new Licenca();
				licenca.setCodigoMaquina(rs.getString("codigo_maquina"));
				licenca.setNomeSoftware(rs.getString("software"));
				licenca.setChave(rs.getString("chave"));
				licenca.setDataExpiracao(rs.getString("data_expiracao"));
				lista.add(licenca);
				
			}while(rs.next());
			pstmt.close();
			rs.close();
			return lista;
			
		}
		
		return lista;
		
	}
	
	
	

}
