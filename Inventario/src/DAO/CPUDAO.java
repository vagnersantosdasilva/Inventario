package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.CPU;


public class CPUDAO {
	
	public boolean incluir(Connection conn ,CPU processador) 
	{
		System.out.println("Chamado incluir");
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
			(
					    "insert into processador "
						+ "(codigo_maquina,"
						+ "nome,"
						+ "numero_de_nucleos,"
						+ "frequenciaMaxima,"
						+ "numero_de_processadores_logicos,"
						+ "fabricante,"
						+ "status_processador)"
						
						+ " values (?,?,?,?,?,?,?)"
			);
			
			pstmt.setString(1,processador.getCodigoMaquina());
			pstmt.setString(2, processador.getNome());
			pstmt.setString(3,processador.getNumeroNucleos());
			pstmt.setString(4, processador.getFrequenciaMaxima());
			pstmt.setString(5, processador.getNumeroProcessadoresLogicos());
			pstmt.setString(6, processador.getFabricante());
			pstmt.setString(7,processador.getStatus());
			
			
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}catch(SQLException e)
		{
			System.out.println("Erro:[CPUDAO:incluir]"+e.getMessage());
			
		}
		return false;
	}
	
	public  boolean excluir (Connection conn , String codigoMaquina) throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement
		(
			"delete from processador "
			+ "where codigo_maquina = ?"
		);
		
		pstmt.setString(1, codigoMaquina);
		int n = pstmt.executeUpdate();
		pstmt.close();
		return n==1;
	}
	
	
	public  CPU buscarProcessador(Connection conn , String codigoMaquina) throws SQLException
	{
		
		CPU processador=new CPU();
		PreparedStatement pstmt = conn.prepareStatement("select * from processador where codigo_maquina=?");
		pstmt.setString(1, codigoMaquina);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next())
		{
			do
			{
				processador.setCodigoMaquina(rs.getString("codigo_maquina"));
				processador.setNome(rs.getString("nome"));
				processador.setNumeroNucleos(rs.getString("numero_de_nucleos"));
				processador.setFrequenciaMaxima(rs.getString("frequenciaMaxima"));
				processador.setNumeroProcessadoresLogicos(rs.getString("numero_de_processadores_logicos"));
				processador.setFabricante(rs.getString("fabricante"));
				processador.setStatus(rs.getString("status_processador"));
				
			}
			while(rs.next());
			rs.close();
			pstmt.close();
			return processador;
		}
		return processador;
	}
	
	public  boolean atualizarRegistros(Connection conn ,CPU unidade) throws SQLException
	{
		System.out.println("Chamado atualizarRegistros");
		PreparedStatement pstmt = conn.prepareStatement
		(
			"update processador set nome=?,"
			+ "numero_de_nucleos=?,"
			+ "frequenciaMaxima=?,"
			+ "numero_de_processadores_logicos=?,"
			+ "fabricante=?, "
			+ "status_processador=? "
			+" where codigo_maquina=?"
		);
		
		pstmt.setString(1, unidade.getNome());
		pstmt.setString(2, unidade.getNumeroNucleos());
		pstmt.setString(3,unidade.getFrequenciaMaxima());
		pstmt.setString(4, unidade.getNumeroProcessadoresLogicos());
		pstmt.setString(5,unidade.getFabricante());
		pstmt.setString(6, unidade.getStatus());
		pstmt.setString(7,unidade.getCodigoMaquina());
		int n = pstmt.executeUpdate();
		pstmt.close();
		
		return n==1;
	}

	public boolean existe(Connection conn, CPU unidade) {
		try
		{
			PreparedStatement pstmt=conn.prepareStatement("select * from processador where codigo_maquina=?");
			pstmt.setString(1, unidade.getCodigoMaquina());
			
			ResultSet rs = pstmt.executeQuery();
			int cont=0;
			if(rs.next()) 
			{
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
			System.out.println("Erro[CPUDAO:existe]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

}
