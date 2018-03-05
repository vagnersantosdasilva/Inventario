package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidades.AdaptadorDeRede;


public class AdaptadoresDeRedeDAO 
{
	
	public boolean incluirLista(Connection conn,List<AdaptadorDeRede> adaptadores) 
	{
		
		try
		{
			for(AdaptadorDeRede adaptador :adaptadores)
			{
				if (existe(conn,adaptador))
				{ 
					atualizarRegistro(conn,adaptador);
				}
				else
				{
					incluir(conn,adaptador);
				}
			}
			return true;
		}	
		catch(Exception e)
		{
			System.out.println("Erro:[AdaptadoresDeRedeDAO:incluirLista]"+e.getMessage());
		}
		return false;
	
	}
	public boolean excluirLista(Connection conn,List<AdaptadorDeRede> adaptadores)
	{
		for(AdaptadorDeRede adaptador:adaptadores)
		{
			try
			{
				if(existe(conn,adaptador))
				{
					excluir(conn, adaptador);
				}
				else
				{
					System.out.println("AdaptadoresDeRedeDAO[.excluirLista]: Registro não encontrado ->"+adaptador.getNome());
				}
			}
			catch(SQLException e)
			{
				System.out.println("AdaptadoresDeRedeDAO[.excluirLista]:"+e.getMessage());
				return false;
			}
			
		}
		return true;
	}
	
	public boolean incluir(Connection conn,AdaptadorDeRede adaptador)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
					(
							"insert into adaptadoresDeRede("
							+ "codigo_maquina,"
							+ "nome,"
							+ "mac_address,"
							+ "indice,"
							+ "ultimo_boot,"
							+ "velocidade,"
							+ "estatus,"
							+ "fabricante,"
							+ "descricacao "
							+ "values(?,?,?,?,?,?,?,?,?) "
							
					);
					pstmt.setString(1, adaptador.getCodigoMaquina());
					pstmt.setString(2, adaptador.getNome());
					pstmt.setString(3, adaptador.getMacAddress());
					pstmt.setString(4, adaptador.getIndice());
					pstmt.setString(5, adaptador.getUltimoReset());
					pstmt.setString(6,adaptador.getVelocidade());
					pstmt.setString(7,adaptador.getStatus());
					pstmt.setString(8,adaptador.getFabricante());
					pstmt.setString(9,adaptador.getDescricao());
					
					int n=pstmt.executeUpdate();
					pstmt.close();
					return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[AdaptadoresDeRedeDAO:inclur]"+e.getMessage());
		}
		return false;	
		
	}
	public boolean atualizarRegistro(Connection conn,AdaptadorDeRede adaptador)
	{
		try
		{		
				PreparedStatement pstmt = conn.prepareStatement
				(
					"update adaptadoresDeRede set "
					+ "nome=?, "
					+ "mac_address=?, "
					+ "ultimo_boot=?,"
					+ "velocidade=?,"
					+ "estatus=?,"
					+ "fabricante=?,"
					+ "descricao=?"
					+ "where codigo_maquina=? and indice=? "
				);
				pstmt.setString(1,adaptador.getNome());
				pstmt.setString(2, adaptador.getMacAddress());
				pstmt.setString(3, adaptador.getUltimoReset());
				pstmt.setString(4,adaptador.getVelocidade());
				pstmt.setString(5, adaptador.getStatus());
				pstmt.setString(6,adaptador.getFabricante());
				pstmt.setString(7,adaptador.getDescricao());
				pstmt.setString(8,adaptador.getCodigoMaquina());
				pstmt.setString(9,adaptador.getIndice());
				int n=pstmt.executeUpdate();
				pstmt.close();
				return n==1;
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[AdaptadorDeRedeDAO:atualizarRegistro] "+e.getMessage());
		}
		return false;
		
	}
	private boolean existe(Connection conn,AdaptadorDeRede adaptador)
	{
		try
		{
			PreparedStatement pstmt = conn.prepareStatement
					(
						"select * from adaptadoresDeRede where codigo_maquina = ? and indice = ?"
					);
					
			pstmt.setString(1,adaptador.getCodigoMaquina());
			pstmt.setString(2,adaptador.getIndice());
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
					
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[AdaptadoresDeRedeDAO:existe]"+e.getMessage());
		}
		return false;
		
	}
	public boolean excluir(Connection conn,AdaptadorDeRede adaptador) throws SQLException
	{
		PreparedStatement pstmt=conn.prepareStatement
		(
				"delete from adaptadores "
				+ "where codigo_maquina=? and "
				+ "indice=?"
		);
		pstmt.setString(1, adaptador.getCodigoMaquina());
		pstmt.setString(2, adaptador.getIndice());
		int n=pstmt.executeUpdate();
		pstmt.close();
		return n==1;
	}
	
	public List obterListaAdaptadores(Connection conn,String codigoMaquina)
	{
		try
		{
			PreparedStatement pstmt=conn.prepareStatement("select * from adaptadoresDeRede where codigo_maquina=?");
			pstmt.setString(1,codigoMaquina);
			ResultSet rs = pstmt.executeQuery();
			List<AdaptadorDeRede> lista = new ArrayList<AdaptadorDeRede>();
			if(rs.next()) 
			{
				do
				{
					AdaptadorDeRede adaptador = new AdaptadorDeRede();
					adaptador.setCodigoMaquina(rs.getString("codigo_maquina"));
					adaptador.setNome(rs.getString("nome"));
					adaptador.setMacAddress(rs.getString("mac_address"));
					adaptador.setUltimoReset(rs.getString("ultimo_boot"));
					adaptador.setDescricao(rs.getString("descricao"));
					adaptador.setFabricante(rs.getString("fabricante"));
					adaptador.setIndice(rs.getString("indice"));
					adaptador.setStatus(rs.getString("estatus"));
					adaptador.setVelocidade(rs.getString("velocidade"));
					lista.add(adaptador);
				}
				while(rs.next());
				pstmt.close();
				rs.close();
			}
			return lista;
		}
		catch(SQLException e)
		{
			System.out.println("Erro:[AdaptadoresDeRede:obterListaAdaptadores]"+e.getMessage());
		}
		return null;
		
		
	}
	

}
