package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidades.Memoria;

public class MemoriasDAO 
{
		public boolean incluir(Connection conn ,Memoria unidade) 
		{
			try
			{
					PreparedStatement pstmt = conn.prepareStatement
						("insert into memorias "
							+ "(codigo_maquina,"
							+ "codigo_slot,"
							+ "capacidade,"
							+ "fabricante,"
							+ "velocidade,"
							+ "tipo,"
							+ "status_drive) "	
							+ " values(?,?,?,?,?,?,?)");
					
					pstmt.setString(1,unidade.getCodigoMaquina());
					pstmt.setInt(2, unidade.getCodigoSlot());
					pstmt.setString(3,unidade.getCapacidade());
					pstmt.setString(4, unidade.getFabricante());
					pstmt.setString(5, unidade.getVelocidade());
					pstmt.setString(6, unidade.getTipo());
					pstmt.setString(7, unidade.getStatus());
					
					
					int n=pstmt.executeUpdate();
					pstmt.close();
					return n==1;
				 
			}
			catch(SQLException e)
			{
				System.out.println("Erro[MemoriasDAO:incluir]"+e.getMessage());
			}
			return false;
		}
		
		public  boolean excluir (Connection conn , String codigoMaquina) 
		{
			try
			{
				PreparedStatement pstmt = conn.prepareStatement
						(
								"delete from memorias "
								+ "where codigo_maquina = ? "
						);
				pstmt.setString(1, codigoMaquina);
				//pstmt.setInt(2, codigoSlot);
				int n = pstmt.executeUpdate();
				pstmt.close();
				return n==1;
			}
			catch(SQLException e)
			{
				System.out.println("Erro[MemoriasDAO:excluir]"+e.getMessage());
			}
			return false;
		}
		
		@SuppressWarnings("null")
		public  List<Memoria> buscarUnidades(Connection conn , String codigoMaquina) 
		{
			List<Memoria> listaDeUnidades = new ArrayList<Memoria>();
			try
			{
				
				
				PreparedStatement pstmt = conn.prepareStatement("select * from memorias where codigo_maquina=?");
				pstmt.setString(1, codigoMaquina);
				ResultSet rs = pstmt.executeQuery();
				
				if (rs.next())
				{
					do
					{
						Memoria unidade = new Memoria();
						unidade.setCodigoMaquina(rs.getString("codigo_maquina"));
						unidade.setCodigoSlot(rs.getInt("codigo_slot"));
						unidade.setCapacidade(rs.getString("capacidade"));
						unidade.setFabricante(rs.getString("fabricante"));
						unidade.setVelocidade(rs.getString("velocidade"));
						unidade.setTipo(rs.getString("tipo"));
						unidade.setStatus(rs.getString("status_drive"));
						listaDeUnidades.add(unidade);
					}
					while(rs.next());
					rs.close();
					pstmt.close();
				}
				return listaDeUnidades;
			}catch(SQLException e)
			{
				System.out.println("Erro:[MemoriasDAO:buscarUnidades]"+e.getMessage());
			}
			return listaDeUnidades;
		}
		
	 //Usando chave dupla para elimiar duplicações
	 // Será necessário Lista no DAO para inserir corretamento os elementos.
		
		public static boolean atualizarRegistro(Connection conn ,Memoria unidade) 
		{
			try
			{
				PreparedStatement pstmt = conn.prepareStatement(
								"update memorias set "
										+ "capacidade=?,"
										+ "fabricante=?,"
										+ "velocidade=?,"
										+ "tipo=?,"
										+ "status_drive=? "	
							        	+ " where codigo_maquina=? "
								        + "and codigo_slot=?"
						);
				
				pstmt.setString(1,unidade.getCapacidade());
				pstmt.setString(2, unidade.getFabricante());
				pstmt.setString(3,unidade.getVelocidade());
				pstmt.setString(4,unidade.getTipo() );
				pstmt.setString(5, unidade.getStatus());
				pstmt.setString(6, unidade.getCodigoMaquina());
				pstmt.setInt(7, unidade.getCodigoSlot() );
				int n = pstmt.executeUpdate();
				pstmt.close();
				return n==1;
			}
			catch(SQLException e)
			{
				System.out.println("Erro[MemoriasDAO:atualizarRegistro]"+e.getMessage());
			}
			return false;
			
		}

		public boolean incluir(Connection conn, List<Memoria> listaMemorias) {
			
			try
			{
				for(Memoria memoria:listaMemorias)
				{
					if(existe(conn,memoria))
					{
						atualizarRegistro(conn,memoria);
						
					}
					else
					{
						incluir(conn,memoria);
					}
				}
				return true;
			}
			catch(Exception e)
			{
				System.out.println("Erro[MemoriasDAO:incluirLista]"+e.getMessage());
			}
			return false;
		}

		private boolean existe(Connection conn, Memoria memoria) 
		{
			try
			{
				PreparedStatement pstmt = conn.prepareStatement("select * from memorias where codigo_maquina=? and codigo_slot=?");
				pstmt.setString(1, memoria.getCodigoMaquina());
				pstmt.setInt(2, memoria.getCodigoSlot());
				ResultSet rs = pstmt.executeQuery();
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
				pstmt.close();
				if (contador>0) return true;
			}
			catch(SQLException e)
			{
				System.out.println("Erro:[MemoriasDAO:existe]"+e.getMessage());
			}
			return false;
		}
}
