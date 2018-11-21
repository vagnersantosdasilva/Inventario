package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.UnidadeArmazenamento;

public class ArmazenamentoDAO 
{
	
	//nesse contexto só serão incluidos ou excluidos registros pelo sistema 
	// nunca diretamente pelo usuário ou administrador 
	
	public boolean incluir(Connection conn,List<UnidadeArmazenamento>listaDeUnidades)
	{
		try
		{
			for(UnidadeArmazenamento unidade:listaDeUnidades)
			{
				if(existe(conn,unidade))
				{
					atualizarRegistros(conn, unidade);
				}
				else
					incluir(conn,unidade);
			}
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Erro:[ArmazenamentoDAO:incluir]"+e.getMessage());
		}
		
		return false;
	}
	
	
	
	public boolean incluir(Connection conn ,UnidadeArmazenamento unidade) 
	{
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement("insert into unidadeArmazenamento "
					+ "(codigo_maquina,codigo_hd,nome,tamanho,tipo_de_interface,tipo_de_midea,status_drive)"	
					+ "values (?,?,?,?,?,?,?)");
		
			pstmt.setString(1,unidade.getCodigoMaquina());
			pstmt.setInt(2, unidade.getCodigoDrive());
			pstmt.setString(3,unidade.getNome());
			pstmt.setString(4, unidade.getTamanho());
			pstmt.setString(5, unidade.getTipoDeInterface());
			pstmt.setString(6, unidade.getTipoDeMidea());
			pstmt.setString(7,unidade.getStatus());
			
			int n=pstmt.executeUpdate();
			pstmt.close();
			return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro[UnidadeArmazenamentoDAO:incluir]"+e.getMessage());
		}
		return false;
	}
	
	public  boolean excluir (Connection conn , String codigoMaquina,int codigoHD) throws SQLException
	{
		PreparedStatement pstmt = conn.prepareStatement("delete from unidadeArmazenamento "
				+ "where codigo_maquina = ? and codigo_hd=?");
		pstmt.setString(1, codigoMaquina);
		pstmt.setInt(2, codigoHD);
		int n = pstmt.executeUpdate();
		pstmt.close();
		return n==1;
	}
	
	@SuppressWarnings("null")
	public  List<UnidadeArmazenamento> buscarUnidades(Connection conn , String codigoMaquina) throws SQLException
	{
		List<UnidadeArmazenamento> listaDeUnidades = new ArrayList<UnidadeArmazenamento>();
		PreparedStatement pstmt = conn.prepareStatement("select * from unidadeArmazenamento where codigo_maquina=?");
		pstmt.setString(1, codigoMaquina);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next())
		{
			do
			{
				UnidadeArmazenamento unidade = new UnidadeArmazenamento();
				unidade.setCodigoMaquina(rs.getString("codigo_maquina"));
				unidade.setCodigoDrive(rs.getInt("codigo_hd"));
				unidade.setNome(rs.getString("nome"));
				unidade.setTamanho(rs.getString("tamanho"));
				unidade.setTipoDeInterface(rs.getString("tipo_de_interface"));
				unidade.setTipoDeMidea(rs.getString("tipo_de_midea"));
				unidade.setStatus(rs.getString("status_drive"));
				listaDeUnidades.add(unidade);
			}
			while(rs.next());
			rs.close();
			pstmt.close();
			return listaDeUnidades;
		}
		return null;
	}
	
 //Usando chave dupla para elimiar duplicações
 // Será necessário Lista no DAO para inserir corretamento os elementos.
	
	private static boolean atualizarRegistros(Connection conn ,UnidadeArmazenamento unidade) throws SQLException
	{
		
		
		PreparedStatement pstmt = conn.prepareStatement("update unidadeArmazenamento set nome=?,"
															+ "tamanho=?,"
															+ "tipo_de_interface=?,"
															+ "tipo_de_midea=?,"
															+ "status_drive=? "
															+ "where codigo_maquina=? "
															+ "and codigo_hd=?");
		
		pstmt.setString(1, unidade.getNome());
		pstmt.setString(2, unidade.getTamanho());
		pstmt.setString(3,unidade.getTipoDeInterface());
		pstmt.setString(4, unidade.getTipoDeMidea());
		pstmt.setString(5,unidade.getStatus());
		pstmt.setString(6, unidade.getCodigoMaquina());
		pstmt.setInt(7, unidade.getCodigoDrive());
		int n = pstmt.executeUpdate();
		pstmt.close();
		return n==1;
	}
	public boolean atualizarRegistros(Connection conn, List<UnidadeArmazenamento> listaUnidadesArmazenamento) 
	{
		return false;
	}
	
	private boolean existe(Connection conn,UnidadeArmazenamento unidade)
	{
		try
		{
			PreparedStatement pstmt=conn.prepareStatement("select * from unidadeArmazenamento where codigo_maquina=? and codigo_hd=?");
			pstmt.setString(1, unidade.getCodigoMaquina());
			pstmt.setInt(2, unidade.getCodigoDrive());
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
			System.out.println("Erro[UnidadeArmazenamentoDAO:existe]"+e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
}
